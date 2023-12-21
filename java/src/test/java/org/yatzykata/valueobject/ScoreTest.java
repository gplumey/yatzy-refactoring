package org.yatzykata.valueobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void getScore_returns_zero_score() {
        var zero_score = new Score(0);
        assertEquals(0, zero_score.getScore());
    }

    @Test
    void getScore_returns_positive_number() {
        var positive_score = new Score(50);
        assertEquals(50, positive_score.getScore());
    }

    @Test
    void getScore_fails_for_negative_number() {
        Executable exec = () -> new Score(-1);
        Throwable thrown = assertThrows(IllegalStateException.class, exec);
        assertEquals("score must be a positive integer.", thrown.getMessage());
    }
}
