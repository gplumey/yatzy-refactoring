package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public class FullHouseScoringStrategy implements ScoringStrategy {

    @Override
    public Score score(Roll roll) {
        return Score.ZERO;
    }
}
