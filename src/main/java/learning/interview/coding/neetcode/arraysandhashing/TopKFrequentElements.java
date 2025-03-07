package learning.interview.coding.neetcode.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/top-k-elements-in-list">problem</a>.
 */
@SuppressWarnings("unused")
public class TopKFrequentElements {

    static class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            var map = new HashMap<Integer, Integer>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            return map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .skip(map.size() - k)
                    .map(Map.Entry::getKey)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
