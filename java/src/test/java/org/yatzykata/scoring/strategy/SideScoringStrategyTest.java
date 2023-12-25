package org.yatzykata.scoring.strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.SideScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SideScoringStrategyTest {

    static Stream<Arguments> score_return_sum_of_sides_equals_to_the_given_side() {
        return Stream.of(
            Arguments.of(Score.of(1), Side.ONE, Roll.of(Side.ONE)),
            Arguments.of(Score.of(2), Side.ONE, Roll.of(Side.ONE, Side.ONE))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_return_sum_of_sides_equals_to_the_given_side(Score expectedScore, Side givenSide, Roll roll) {
        SideScoringStrategy oneScoringStrategy = new SideScoringStrategy(givenSide);
        assertEquals(expectedScore, oneScoringStrategy.score(roll));
    }
}
