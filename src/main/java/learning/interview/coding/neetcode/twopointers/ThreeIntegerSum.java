package learning.interview.coding.neetcode.twopointers;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class ThreeIntegerSum {

    static class BruteForceSolution {
        public List<List<Integer>> threeSum(int[] nums) {
            var setOfTriplets = new HashSet<OrderedIntegerTriplet>();
            for (int i=0; i<nums.length; i++) {
                for (int j=i+1; j<nums.length; j++) {
                    for (int l=j+1; l<nums.length; l++) {
                        if (nums[i] + nums[j] + nums[l] == 0) {
                            setOfTriplets.add(OrderedIntegerTriplet
                                    .ofThreeIntegers(nums[i], nums[j], nums[l]));
                        }
                    }
                }
            }
            return setOfTriplets.stream()
                    .map(OrderedIntegerTriplet::getTriplet)
                    .toList();
        }

        private static class OrderedIntegerTriplet {

            private final List<Integer> triplet;

            private OrderedIntegerTriplet(Stream<Integer> intStream) {
                this.triplet = intStream.sorted().toList();
            }

            static OrderedIntegerTriplet ofThreeIntegers(Integer e1, Integer e2, Integer e3) {
                return new OrderedIntegerTriplet(Stream.of(e1, e2, e3));
            }

            public List<Integer> getTriplet() {
                return triplet;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                OrderedIntegerTriplet that = (OrderedIntegerTriplet) o;

                return triplet.equals(that.triplet);
            }

            @Override
            public int hashCode() {
                return triplet.hashCode();
            }
        }
    }
}
