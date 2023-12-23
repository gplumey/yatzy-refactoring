package org.yatzykata.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairScoringStrategyTest {
    PairScoringStrategy pairScoringStrategy;

    @BeforeEach
    void setup() {
        this.pairScoringStrategy = new PairScoringStrategy();
    }

    @Test
    void score_sums_single_pair() {
        var singlePairRoll = Roll.of(Side.ONE, Side.ONE, Side.TWO);
        assertEquals(Score.of(2), pairScoringStrategy.score(singlePairRoll));
    }

    @Test
    void score_sums_highest_pair_when_two_pairs_exists() {
       var twoPairRoll = Roll.of(Side.TWO, Side.THREE, Side.THREE, Side.TWO);
        assertEquals(Score.of(6), pairScoringStrategy.score(twoPairRoll));
    }
}
