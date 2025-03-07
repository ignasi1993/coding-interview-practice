package learning.interview.coding.neetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater.BruteForceSolution bruteForceSolution = new ContainerWithMostWater.BruteForceSolution();
    private final ContainerWithMostWater.OptimalSolution optimalSolution = new ContainerWithMostWater.OptimalSolution();

    @Test
    void bruteForceTest() {
        // given
        int[] heights = new int[]{1,7,2,5,4,7,3,6};

        // when
        int result = bruteForceSolution.maxArea(heights);

        // then
        assertEquals(36, result);
    }

    @Test
    void optimalSolutionTest() {
        // given
        int[] heights = new int[]{1,7,2,5,4,7,3,6};

        // when
        int result = optimalSolution.maxArea(heights);

        // then
        assertEquals(36, result);
    }
}
