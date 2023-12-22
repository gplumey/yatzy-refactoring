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
        var roll = Roll.of( new Dice(Side.ONE));
        var dices = roll.dices();
        assertEquals(1, dices.size());
    }

    @ParameterizedTest
    @NullSource
    void throw_IllegalStateException_when_a_dice_is_null(Dice nullDide) {
        Executable exec = () -> Roll.of(nullDide);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("All dices must not be null", thrown.getMessage());
    }

    @Test
    void throw_IllegalStateException_when_dices_is_null() {
        Executable exec = () -> new Roll(null);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("dices most not be null", thrown.getMessage());
    }
}
