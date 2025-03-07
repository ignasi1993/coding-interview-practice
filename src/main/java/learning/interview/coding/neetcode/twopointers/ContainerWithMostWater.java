package learning.interview.coding.neetcode.twopointers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/max-water-container">problem</a>.
 */
public class ContainerWithMostWater {

    static class BruteForceSolution {

        public int maxArea(int[] heights) {
            int maxArea = 0;
            for (int i=0; i<heights.length; i++) {
                for (int j=i+1; j<heights.length; j++) {
                    int area = getArea(heights, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
            return maxArea;
        }

        private static int getArea(int[] heights, int i, int j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            return height*width;
        }
    }

    static class OptimalSolution {

        public int maxArea(int[] heights) {
            if (heights.length < 2) {
                return 0;
            }
            var containerComparator = new ContainerComparator(heights);
            int smallerPointer = 0;
            int biggerPointer = heights.length - 1;
            var currentBiggestContainer = new Container(smallerPointer, biggerPointer);
            while (smallerPointer < biggerPointer) {
                if (heights[smallerPointer] < heights[biggerPointer]) {
                    smallerPointer++;
                } else {
                    biggerPointer--;
                }
                Container pointersContainer = new Container(smallerPointer, biggerPointer);
                currentBiggestContainer = containerComparator.max(pointersContainer, currentBiggestContainer);
            }
            return containerComparator.getArea(currentBiggestContainer);
        }

        private static class ContainerComparator implements Comparator<Container> {

            private final int[] heights;

            public ContainerComparator(int[] heights) {
                this.heights = heights;
            }

            public int getArea(Container container) {
                int width = container.barIndex2() - container.barIndex1();
                int height = Math.min(heights[container.barIndex1()], heights[container.barIndex2()]);
                return width*height;
            }

            @Override
            public int compare(Container o1, Container o2) {
                return getArea(o1) - getArea(o2);
            }

            public Container max(Container... containers) {
                return Collections.max(List.of(containers), this);
            }
        }

        private record Container(int barIndex1, int barIndex2) {}
    }
}
