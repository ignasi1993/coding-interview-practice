package learning.interview.coding.neetcode.arraysandhashing;

import java.util.*;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/longest-consecutive-sequence">problem</a>.
 */
public class LongestConsecutiveSequence {

    static class Solution1 {
        public int longestConsecutive(int[] nums) {
            Map<Integer, LinkedList<Integer>> tailsMap = new HashMap<>();
            Map<Integer, LinkedList<Integer>> headsMap = new HashMap<>();
            Set<Integer> processedIntegers = new HashSet<>();
            int maxLength = 0;
            for (int num : nums) {
                if (processedIntegers.contains(num)) {
                    continue;
                }
                processedIntegers.add(num);
                int higherNumber = num + 1;
                boolean isTail = tailsMap.containsKey(higherNumber);
                int lowerNumber = num - 1;
                boolean isHead = headsMap.containsKey(lowerNumber);
                if (isHead && isTail) {
                    var lowerList = headsMap.get(lowerNumber);
                    lowerList.addLast(num);
                    lowerList.addAll(tailsMap.get(higherNumber));
                    tailsMap.remove(higherNumber);
                    headsMap.remove(lowerNumber);
                    headsMap.put(lowerList.getLast(), lowerList);
                    maxLength = Math.max(maxLength, lowerList.size());
                } else if (isHead || isTail) {
                    if (isTail) {
                        LinkedList<Integer> list = tailsMap.get(higherNumber);
                        list.addFirst(num);
                        tailsMap.put(num, list);
                        tailsMap.remove(higherNumber);
                        maxLength = Math.max(maxLength, list.size());
                    }
                    if (isHead) {
                        LinkedList<Integer> list = headsMap.get(lowerNumber);
                        list.addLast(num);
                        headsMap.put(num, list);
                        headsMap.remove(lowerNumber);
                        maxLength = Math.max(maxLength, list.size());
                    }
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(num);
                    tailsMap.put(num, list);
                    headsMap.put(num, list);
                    maxLength = Math.max(maxLength, list.size());
                }
            }
            return maxLength;
        }
    }
}
