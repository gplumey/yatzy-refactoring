package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class ChanceScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        return roll.read().stream()
                   .map(Side::score)
                   .reduce(Score.ZERO, (total, sideScore) -> total.sum(sideScore));
    }
}
