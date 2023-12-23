package org.yatzykata.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeOfKindScoringStrategyTest {
    ThreeOfKindScoringStrategy threeOfKindScoringStrategy;

    @BeforeEach
    void setup() {
        this.threeOfKindScoringStrategy = new ThreeOfKindScoringStrategy();
    }

    @Test
    void score_sums_three_of_a_kind() {
        var roll = Roll.of(Side.ONE, Side.ONE, Side.ONE);
        assertEquals(Score.of(3), threeOfKindScoringStrategy.score(roll));
    }


    @Test
    void score_returns_ZERO_when_no_pair_exits() {
        var noPairRoll = Roll.of(Side.ONE, Side.THREE, Side.TWO, Side.FOUR);
        assertEquals(Score.ZERO, threeOfKindScoringStrategy.score(noPairRoll));
    }
}
