package org.yatzykata.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairScoringStrategyTest {
    PairScoringStrategy pairScoringStrategy;

    @BeforeEach
    void setup() {
        this.pairScoringStrategy = new PairScoringStrategy();
    }

    static Stream<Arguments> score_fails() {
        return Stream.of(
            Arguments.of(Roll.of(Side.ONE, Side.ONE, Side.TWO))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_fails(Roll roll) {
        assertEquals(Score.of(2), pairScoringStrategy.score(roll));
    }

}
