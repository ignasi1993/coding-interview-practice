package learning.interview.coding.neetcode.arraysandhashing;

import java.util.HashMap;

@SuppressWarnings("unused")
public class TwoIntegerSum {

    static class Solution1 {
        public int[] twoSum(int[] nums, int target) throws Exception {
            var map = new HashMap<Integer, Integer>(nums.length);
            for (int i=0; i<nums.length; i++) {
                int potentialPair = target - nums[i];
                if (map.containsKey(potentialPair)) {
                    return new int[]{map.get(potentialPair), i};
                }
                map.put(nums[i], i);
            }
            throw new Exception("There were no combinations");
        }
    }
}
