package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.Set;

public class SmallStraightScoringStrategy implements ScoringStrategy {
    private static final Set<Side> SMALL_STRAIGHT_SIDES = Set.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE);

    @Override
    public Score score(Roll roll) {
        var rollSides = Set.copyOf(roll.read());
        var canReadSmallStraight = rollSides.containsAll(SMALL_STRAIGHT_SIDES);
        return canReadSmallStraight ? Score.SMALL_STRAIGHT : Score.ZERO;
    }
}
