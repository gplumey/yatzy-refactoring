package org.yatzykata.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoPairScoringStrategyTest {
    TwoPairScoringStrategy twoPairScoringStrategy;

    @BeforeEach
    void setup() {
        this.twoPairScoringStrategy = new TwoPairScoringStrategy();
    }

    @Test
    void score_sums_two_pair() {
        var twoPairRoll = Roll.of(Side.ONE, Side.ONE, Side.TWO, Side.TWO);
        assertEquals(Score.of(6), twoPairScoringStrategy.score(twoPairRoll));
    }

}
