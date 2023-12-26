package org.yatzykata.scoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.FourOfKindScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourOfKindScoringStrategyTest {
    FourOfKindScoringStrategy fourOfKindScoringStrategy;

    @BeforeEach
    void setup() {
        this.fourOfKindScoringStrategy = new FourOfKindScoringStrategy();
    }

    static Stream<Arguments> score_sums_four_of_a_kind() {
        return Stream.of(
            Arguments.of(Score.of(4), Roll.of(Side.ONE, Side.ONE, Side.ONE, Side.ONE)),
            Arguments.of(Score.of(12), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE)),
            Arguments.of(Score.of(8), Roll.of(Side.TWO, Side.ONE,Side.TWO, Side.TWO, Side.THREE, Side.TWO))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_sums_four_of_a_kind(Score expectedScore, Roll roll) {
        assertEquals(expectedScore, fourOfKindScoringStrategy.score(roll));
    }


    @Test
    void score_returns_ZERO_when_not_exits() {
        var noPairRoll = Roll.of(Side.ONE, Side.THREE, Side.TWO, Side.ONE, Side.ONE);
        assertEquals(Score.ZERO, fourOfKindScoringStrategy.score(noPairRoll));
    }
}
