package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public class ThreeOfKindScoringStrategy implements ScoringStrategy {
    @Override
    public Score score(Roll roll) {
        return Score.ZERO;
    }
}