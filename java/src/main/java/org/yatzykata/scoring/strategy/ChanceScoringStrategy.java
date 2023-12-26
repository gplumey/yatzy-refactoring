package org.yatzykata.scoring.strategy;

import org.yatzykata.scoring.ScoringStrategy;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class ChanceScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        return roll.read().stream()
                   .map(Side::score)
                   .reduce(Score.ZERO, Score::sum);
    }
}
