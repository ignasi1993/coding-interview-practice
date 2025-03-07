package learning.interview.coding.neetcode.twopointers;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/two-integer-sum-ii">problem</a>.
 */
@SuppressWarnings("unused")
public class TwoSumIIInputArrayIsSorted {

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i=0; i<numbers.length; i++) {
                for (int j=i+1; j<numbers.length; j++) {
                    if (numbers[i] + numbers[j] == target) {
                        return new int[]{i+1, j+1};
                    }
                }
            }
            return new int[2];
        }
    }
}
