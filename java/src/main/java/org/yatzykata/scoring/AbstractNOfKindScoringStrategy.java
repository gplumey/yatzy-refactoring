package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;
import java.util.Comparator;

public class AbstractNOfKindScoringStrategy implements ScoringStrategy {

    private final int expectedNumberOfSameSide ;

    protected AbstractNOfKindScoringStrategy(int expectedNumberOfSameSide) {
        this.expectedNumberOfSameSide = expectedNumberOfSameSide;
    }

    @Override
    public Score score(Roll roll) {
        Collection<Side> sides = roll.atLeastNTime(expectedNumberOfSameSide);
        if(!sides.isEmpty()) {
            var sortByScoreDesc = sides.stream().sorted(Comparator.reverseOrder());
            var highestPair = sortByScoreDesc.iterator().next();
            var pairScore = highestPair.score();
            return pairScore.multiple(expectedNumberOfSameSide);
        } else {
            return Score.ZERO;
        }
    }

}
