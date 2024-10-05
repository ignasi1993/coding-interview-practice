package learning.interview.coding.neetcode.arraysandhashing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence.Solution1 solution1 = new LongestConsecutiveSequence.Solution1();

    @Test
    void testSolution1() {
        // given
        int[] parameter = new int[]{2,20,4,10,3,4,5};

        // when
        int result = solution1.longestConsecutive(parameter);

        // then
        assertThat(result).isEqualTo(4);
    }
}
