package org.yatzykata.scoring.strategy;

import org.yatzykata.scoring.ScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public class YatzyScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        return roll.areAllSideEqual() ? Score.YATZY : Score.ZERO;
    }
}
