package learning.interview.coding.neetcode.arraysandhashing;

import java.util.HashSet;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/duplicate-integer">problem</a>.
 */
@SuppressWarnings("unused")
public class ContainsDuplicate {

    static class Solution1 {
        public boolean hasDuplicate(int[] nums) {
            int[] uniqueNums = new int[nums.length];
            int uniqueNumsFilledElements = 0;
            for (int num : nums) {
                if (!isInArray(num, uniqueNums, uniqueNumsFilledElements)) {
                    uniqueNums[uniqueNumsFilledElements] = num;
                    uniqueNumsFilledElements++;
                } else {
                    return true;
                }
            }
            return false;
        }

        private boolean isInArray(int num, int[] nums, int uniqueNumsFilledElements) {
            for (int j=0; j<uniqueNumsFilledElements; j++) {
                if (num == nums[j]) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution2 {
        public boolean hasDuplicate(int[] nums) {
            var uniqueNums = new HashSet<Integer>(nums.length);
            for (int num : nums) {
                if (uniqueNums.contains(num)) {
                    return true;
                }
                uniqueNums.add(num);
            }
            return false;
        }
    }
}
