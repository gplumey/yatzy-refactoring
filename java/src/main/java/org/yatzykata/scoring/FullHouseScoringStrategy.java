package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Collection;
import java.util.function.Predicate;

public class FullHouseScoringStrategy implements ScoringStrategy {
    private static final int FULL_HOUSE_DICE_EXPECTED = 5;

    @Override
    public Score score(Roll roll) {
        if (roll.read().size() == FULL_HOUSE_DICE_EXPECTED) {
            Collection<Side> threes = roll.atLeastNTime(3);
            if (!threes.isEmpty()) {
                var threesSide = threes.iterator().next();
                Collection<Side> twos = roll.atLeastNTime(2);
                var twosMinusThrees = twos.stream().filter(Predicate.not(Predicate.isEqual(threesSide))).findFirst();
                if (twosMinusThrees.isPresent()) {
                    var threesScore = threesSide.score().multiple(3);
                    var twosScore = twosMinusThrees.get().score().multiple(2);
                    return threesScore.sum(twosScore);
                }
            }
        }
        return Score.ZERO;
    }
}
