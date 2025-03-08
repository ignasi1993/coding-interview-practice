package learning.interview.coding.neetcode.twopointers;

/**
 * Based on neetcode.io's <a href="https://neetcode.io/problems/trapping-rain-water">problem</a>.
 */
public class TrappingRainWater {

    static class OptimalSolution {

        public int trap(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int barIndex1 = height[0] < height[1] ? 1 : 0;
            int currentContainerArea = 0;
            int totalArea = 0;
            for (int i=barIndex1+1; i<height.length; i++) {
                if (height[i] < height[barIndex1]) {
                    currentContainerArea = currentContainerArea + (height[barIndex1] - height[i]);
                } else {
                    totalArea += currentContainerArea;
                    currentContainerArea = 0;
                    barIndex1 = i;
                }
            }
            if (currentContainerArea > 0 && height.length - 1 - barIndex1 > 1) {
                int barIndex2 = height[height.length - 2] < height[height.length - 1] ? height.length - 1 : height.length - 2;
                currentContainerArea = 0;
                for (int i=barIndex2-1; i>barIndex1; i--) {
                    if (height[i] < height[barIndex2]) {
                        currentContainerArea = currentContainerArea + (height[barIndex2] - height[i]);
                    } else {
                        totalArea += currentContainerArea;
                        currentContainerArea = 0;
                        barIndex2 = i;
                    }
                }
                totalArea += currentContainerArea;
            }
            return totalArea;
        }
    }
}
