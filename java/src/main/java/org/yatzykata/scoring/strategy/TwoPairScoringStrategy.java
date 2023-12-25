package org.yatzykata.scoring.strategy;

import org.yatzykata.scoring.ScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;
import java.util.Comparator;

public class TwoPairScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        Collection<Side> pairs = roll.atLeastNTime(2);
        if(pairs.size() > 1) {
            var sortByScoreDesc = pairs.stream().sorted(Comparator.comparing(Side::score, Comparator.reverseOrder()));
            var iterator = sortByScoreDesc.iterator();
            var highestPair1 = iterator.next();
            var highestPair2 = iterator.next();
            var pair1Score = highestPair1.score().multiple(2);
            var pair2Score = highestPair2.score().multiple(2);
            return pair1Score.sum(pair2Score);
        } else {
            return Score.ZERO;
        }
    }
}
