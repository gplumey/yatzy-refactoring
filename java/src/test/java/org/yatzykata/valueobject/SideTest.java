package org.yatzykata.valueobject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SideTest {

    static Stream<Arguments> number_returns_right_face_number() {
        return Stream.of(
            Arguments.of(1, Side.ONE),
            Arguments.of(2, Side.TWO),
            Arguments.of(3, Side.THREE),
            Arguments.of(4, Side.FOUR),
            Arguments.of(5, Side.FIVE),
            Arguments.of(6, Side.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource
    void number_returns_right_face_number(int expectedFaceNumber, Side givenFace) {
        assertEquals(expectedFaceNumber, givenFace.number());
    }
}
