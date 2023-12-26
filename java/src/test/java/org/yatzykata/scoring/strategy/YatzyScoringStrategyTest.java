package org.yatzykata.scoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.YatzyScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyScoringStrategyTest {
    YatzyScoringStrategy yatzyScoringStrategy;

    @BeforeEach
    void setup() {
        this.yatzyScoringStrategy = new YatzyScoringStrategy();
    }

    static Stream<Arguments> score_returns_YATZY_when_all_dice_have_are_same() {
        return Stream.of(
            Arguments.of(Roll.of(Side.ONE)),
            Arguments.of(Roll.of(Side.TWO, Side.TWO))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_returns_YATZY_when_all_dice_have_are_same(Roll roll) {
        assertEquals(Score.YATZY, yatzyScoringStrategy.score(roll));
    }


    @Test
    void score_returns_ZERO_when_dices_are_not_same() {
        var roll = Roll.of(Side.ONE, Side.TWO);
        assertEquals(Score.ZERO, yatzyScoringStrategy.score(roll));
    }
}
