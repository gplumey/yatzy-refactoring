package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;

public class PairScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        Collection<Side> pairs = roll.pairs();
        if(pairs.size() > 0) {
            var firstPair = pairs.iterator().next();
            var pairScore = firstPair.score();
            return pairScore.multiple(2);
        } else {
            return Score.ZERO;
        }
    }
}
