package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public class FullHouseScoringStrategy implements ScoringStrategy {
    private static final int FULL_HOUSE_DICE_EXPECTED = 5;


    private static boolean isFullHouse(Roll.CounterSideTuple first, Roll.CounterSideTuple second) {
        return first.count() == 3 && second.count() == 2
            || first.count() == 2 && second.count() == 3;
    }

    @Override
    public Score score(Roll roll) {
        if (roll.read().size() == FULL_HOUSE_DICE_EXPECTED) {
            var counterTuples = roll.counterSideTuples();
            var firstTuple =  counterTuples.get(0);
            var secondTuple = counterTuples.get(1);
            if (isFullHouse(firstTuple, secondTuple)) {
                var firstScore = firstTuple.side().score().multiple(firstTuple.count());
                var secondScore = secondTuple.side().score().multiple(secondTuple.count());
                return firstScore.sum(secondScore);
            }
        }
        return Score.ZERO;
    }
}
