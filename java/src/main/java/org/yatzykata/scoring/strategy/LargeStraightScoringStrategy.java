package org.yatzykata.scoring.strategy;

import org.yatzykata.scoring.ScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Set;

public class LargeStraightScoringStrategy implements ScoringStrategy {
    private static final Set<Side> LARGE_STRAIGHT_SIDES = Set.of( Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.SIX);

    @Override
    public Score score(Roll roll) {
        var rollSides = Set.copyOf(roll.read());
        var canReadSmallStraight = rollSides.containsAll(LARGE_STRAIGHT_SIDES);
        return canReadSmallStraight ? Score.LARGE_STRAIGHT : Score.ZERO;
    }
}
