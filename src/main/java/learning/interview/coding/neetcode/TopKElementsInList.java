package learning.interview.coding.neetcode;

import java.util.HashMap;
import java.util.Map;

public class TopKElementsInList {

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
