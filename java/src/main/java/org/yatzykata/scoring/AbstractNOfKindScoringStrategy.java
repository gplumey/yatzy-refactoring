package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;
import java.util.Comparator;

public abstract class AbstractNOfKindScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        Collection<Side> sides = roll.atLeastNTime(expectedNumberOfSameSide());
        if(!sides.isEmpty()) {
            var sortByScoreDesc = sides.stream().sorted(Comparator.reverseOrder());
            var highestPair = sortByScoreDesc.iterator().next();
            var pairScore = highestPair.score();
            return pairScore.multiple(expectedNumberOfSameSide());
        } else {
            return Score.ZERO;
        }
    }

    protected abstract int expectedNumberOfSameSide();
}
