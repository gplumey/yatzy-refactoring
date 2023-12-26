package org.yatzykata.scoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.LargeStraightScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargeStraightScoringStrategyTest {
    LargeStraightScoringStrategy largeStraightScoringStrategy;

    @BeforeEach
    void setup() {
        this.largeStraightScoringStrategy = new LargeStraightScoringStrategy();
    }

    static Stream<Arguments> score_returns_LARGE_STRAIGHT_score_when_a_small_straight_is_read() {
        return Stream.of(
            Arguments.of( Roll.of( Side.TWO, Side.THREE, Side.FOUR, Side.FIVE,Side.SIX)),
            Arguments.of( Roll.of(Side.FIVE, Side.THREE, Side.TWO, Side.FOUR, Side.SIX)),
            Arguments.of( Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.SIX))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_returns_LARGE_STRAIGHT_score_when_a_small_straight_is_read( Roll roll) {
        assertEquals(Score.LARGE_STRAIGHT, largeStraightScoringStrategy.score(roll));
    }


    @Test
    void score_returns_ZERO_when_not_exits() {
        var noPairRoll = Roll.of(Side.ONE, Side.THREE, Side.TWO, Side.FOUR, Side.ONE);
        assertEquals(Score.ZERO, largeStraightScoringStrategy.score(noPairRoll));
    }
}
