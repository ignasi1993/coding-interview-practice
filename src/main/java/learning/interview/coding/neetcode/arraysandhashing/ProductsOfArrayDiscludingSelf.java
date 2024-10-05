package learning.interview.coding.neetcode.arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unused")
public class ProductsOfArrayDiscludingSelf {

    static class Solution1 {

        public int[] productExceptSelf(int[] nums) {
            var set = new HashSet<Integer>(nums.length);
            int product = 1;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == 0) {
                    set.add(i);
                    if (set.size() > 1) {
                        product = 0;
                        break;
                    }
                    continue;
                }
                product = product*nums[i];
            }
            int[] result = new int[nums.length];
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else if (set.size() > 0) {
                    result[i] = 0;
                } else {
                    result[i] = product/nums[i];
                }
            }
            return result;
        }
    }

    static class Solution2 {

        public int[] productExceptSelf(int[] nums) {
            var map = new HashMap<Integer, Integer>(nums.length);
            int partialProduct = 1;
            for (int i=0; i<nums.length; i++) {
                map.put(i, partialProduct);
                partialProduct = partialProduct*nums[i];
            }
            int inverseProduct = 1;
            var result = new int[nums.length];
            for (int i=nums.length-1; i>=0; i--) {
                result[i] = inverseProduct*map.get(i);
                inverseProduct = inverseProduct*nums[i];
            }
            return result;
        }
    }
}
