package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class YatzyScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        return roll.areAllSideEqual() ? Score.YATZY : Score.ZERO;
    }
}
