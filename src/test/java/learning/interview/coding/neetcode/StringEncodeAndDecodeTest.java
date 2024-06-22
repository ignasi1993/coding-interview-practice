package learning.interview.coding.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringEncodeAndDecodeTest {

    private final StringEncodeAndDecode.Solution stringEncodeAndDecode = new StringEncodeAndDecode.Solution();

    @ParameterizedTest
    @MethodSource(value = "provideTestArguments")
    void should(List<String> argument) {
        // given - when
        String encoded = stringEncodeAndDecode.encode(argument);
        List<String> result = stringEncodeAndDecode.decode(encoded);

        // then
        assertThat(result).isEqualTo(argument);
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(Arguments.of(List.of()), Arguments.of(List.of("")));
    }
}
