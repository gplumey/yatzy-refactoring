package org.yatzykata.scoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.ThreeOfKindScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeOfKindScoringStrategyTest {
    ThreeOfKindScoringStrategy threeOfKindScoringStrategy;

    @BeforeEach
    void setup() {
        this.threeOfKindScoringStrategy = new ThreeOfKindScoringStrategy();
    }

    static Stream<Arguments> score_sums_three_of_a_kind() {
        return Stream.of(
            Arguments.of(Score.of(3), Roll.of(Side.ONE, Side.ONE, Side.ONE)),
            Arguments.of(Score.of(9), Roll.of(Side.THREE, Side.THREE, Side.THREE)),
            Arguments.of(Score.of(6), Roll.of(Side.ONE,Side.TWO, Side.TWO, Side.THREE, Side.TWO))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_sums_three_of_a_kind(Score expectedScore, Roll roll) {
        assertEquals(expectedScore, threeOfKindScoringStrategy.score(roll));
    }

    @Test
    void score_returns_ZERO_when_not_exits() {
        var noPairRoll = Roll.of(Side.ONE, Side.THREE, Side.TWO, Side.FOUR, Side.ONE);
        assertEquals(Score.ZERO, threeOfKindScoringStrategy.score(noPairRoll));
    }
}
