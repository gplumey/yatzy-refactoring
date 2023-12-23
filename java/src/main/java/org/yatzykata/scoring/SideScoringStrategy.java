package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class SideScoringStrategy implements ScoringStrategy {

    private final Side lookupSide;

    public SideScoringStrategy(Side lookupSide) {
        this.lookupSide = lookupSide;
    }

    @Override
    public Score score(Roll roll) {
        int sideCount = roll.countBySide(lookupSide);
        return lookupSide.score().multiple(sideCount);
    }
}
