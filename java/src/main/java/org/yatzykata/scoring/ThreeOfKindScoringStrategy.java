package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;
import java.util.Comparator;

public class ThreeOfKindScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        Collection<Side> sides = roll.atLeastNTime(3);
        if(sides.size() > 0) {
            var sortByScoreDesc = sides.stream().sorted(Comparator.reverseOrder());
            var highestPair = sortByScoreDesc.iterator().next();
            var pairScore = highestPair.score();
            return pairScore.multiple(3);
        } else {
            return Score.ZERO;
        }
    }
}
