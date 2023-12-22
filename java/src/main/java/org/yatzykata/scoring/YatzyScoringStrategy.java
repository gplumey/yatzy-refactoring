package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class ChanceScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        var initialScore = Score.of(0);
        return  roll.read().stream().map(Side::score).reduce(initialScore, (total, sideScore ) -> total.sum(sideScore));
    }
}
