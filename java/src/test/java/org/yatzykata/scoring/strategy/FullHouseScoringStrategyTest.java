package org.yatzykata.scoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.strategy.FullHouseScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullHouseScoringStrategyTest {
    FullHouseScoringStrategy fullHouseScoringStrategy;

    @BeforeEach
    void setup() {
        this.fullHouseScoringStrategy = new FullHouseScoringStrategy();
    }

    static Stream<Arguments> score_sides_when_a_full_house_is_read() {
        return Stream.of(
            Arguments.of(Score.of(7), Roll.of( Side.ONE, Side.ONE, Side.ONE, Side.TWO,Side.TWO)),
            Arguments.of(Score.of(13), Roll.of( Side.THREE, Side.THREE, Side.THREE, Side.TWO,Side.TWO))
        );
    }

    @ParameterizedTest
    @MethodSource
    void score_sides_when_a_full_house_is_read(Score expectedScore,  Roll roll) {
        assertEquals(expectedScore, fullHouseScoringStrategy.score(roll));
    }


    @Test
    void score_returns_ZERO_when_full_house_is_not_read() {
        var noPairRoll = Roll.of(Side.ONE, Side.THREE, Side.TWO, Side.FOUR, Side.ONE);
        assertEquals(Score.ZERO, fullHouseScoringStrategy.score(noPairRoll));
    }

    @Test
    void score_returns_ZERO_when_less_than_5_dices() {
        var noPairRoll = Roll.of(Side.ONE, Side.ONE, Side.TWO, Side.ONE);
        assertEquals(Score.ZERO, fullHouseScoringStrategy.score(noPairRoll));
    }


    @Test
    void score_returns_ZERO_when_more_than_5_dices() {
        var noPairRoll = Roll.of(Side.ONE, Side.ONE, Side.TWO, Side.ONE, Side.TWO, Side.THREE);
        assertEquals(Score.ZERO, fullHouseScoringStrategy.score(noPairRoll));
    }
}
