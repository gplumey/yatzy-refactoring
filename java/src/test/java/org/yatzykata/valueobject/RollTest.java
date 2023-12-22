package org.yatzykata.valueobject;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RollTest {


    @Test
    public void constructs_a_roll_of_one_dice() {
        var roll = Roll.of(Side.ONE);
        var sides = roll.read();
        assertEquals(1, sides.size());
    }

    @ParameterizedTest
    @NullSource
    void throw_IllegalStateException_when_a_dice_is_null(Side nullDide) {
        Executable exec = () -> Roll.of(nullDide);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("All sides must not be null", thrown.getMessage());
    }

    @Test
    void throw_IllegalStateException_when_dices_is_null() {
        Executable exec = () -> new Roll(null);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("sides most not be null", thrown.getMessage());
    }

    static Stream<Arguments> countBySide_returns_the_count_of_the_given_side() {
        return Stream.of(
            Arguments.of(1, Side.ONE, Roll.of(Side.ONE)),
            Arguments.of(2, Side.ONE, Roll.of(Side.ONE, Side.ONE))
        );
    }

    ;

    @ParameterizedTest
    @MethodSource
    void countBySide_returns_the_count_of_the_given_side(int expectedCount, Side side, Roll roll) {
        assertEquals(expectedCount, roll.countBySide(side));
    }
}
