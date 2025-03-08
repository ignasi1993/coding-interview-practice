package learning.interview.coding.neetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    private final TrappingRainWater.OptimalSolution optimalSolution = new TrappingRainWater.OptimalSolution();

    @Test
    void testBruteForceSolution() {
        // given
        int[] heights = new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1};

        // when
        int result = optimalSolution.trap(heights);

        // then
        assertEquals(9, result);
    }
}
