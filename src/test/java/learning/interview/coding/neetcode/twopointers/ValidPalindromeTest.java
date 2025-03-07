package learning.interview.coding.neetcode.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {

    private final ValidPalindrome.Solution solution = new ValidPalindrome.Solution();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void testIsPalindrome(String testString, boolean expectedResult) {
        // given - when
        boolean result = solution.isPalindrome(testString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("Was it a car or a cat I saw?", true),
                Arguments.of("0P", false)
        );
    }
}
