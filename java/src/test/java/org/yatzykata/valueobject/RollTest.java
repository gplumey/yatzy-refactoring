package org.yatzykata.valueobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

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
}
