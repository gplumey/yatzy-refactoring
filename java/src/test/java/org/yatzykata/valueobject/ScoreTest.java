package org.yatzykata.valueobject;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreTest {

    @Test
    void constructs_when_zero_score() {
        var zero_score = Score.of(0);
        assertEquals(0, zero_score.value());
    }

    @Test
    void constructs_when_positive_number() {
        var positive_score = Score.of(50);
        assertEquals(50, positive_score.value());
    }

    @Test
    void throws_IllegalStateException_when_negative_number() {
        Executable exec = () -> Score.of(-1);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("value must be a positive integer.", thrown.getMessage());
    }

    private static Stream<Arguments> sum_a_and_b() {
        return Stream.of(
            Arguments.of(Score.of(0), Score.of(0), Score.of(0)),
            Arguments.of(Score.of(99), Score.of(0), Score.of(99)),
            Arguments.of(Score.of(50), Score.of(50), Score.of(0)),
            Arguments.of(Score.of(100), Score.of(50), Score.of(50))
        );
    }

    @ParameterizedTest
    @MethodSource
    void sum_a_and_b(Score expectedResult, Score a, Score b) {
        assertEquals(expectedResult, a.sum(b));
    }

    @Nested
    class Multiply{
        @Test
        void multiple_5_by_4_returns_20() {
            var result = Score.of(5).multiple(4);
            assertEquals(Score.of(20), result);
        }

        @Test
        void multiple_0_by_0_returns_0() {
            var result = Score.ZERO.multiple(0);
            assertEquals(Score.ZERO, result);
        }
    }
}
