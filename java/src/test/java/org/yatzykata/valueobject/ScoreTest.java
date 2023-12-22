package org.yatzykata.valueobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

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
    void throws_IllegaleStateException_when_negative_number() {
        Executable exec = () -> Score.of(-1);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("value must be a positive integer.", thrown.getMessage());
    }

}
