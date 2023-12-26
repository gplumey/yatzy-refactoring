package org.yatzykata.scoring;

import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public interface ScoringStrategy {
    Score score(Roll roll);
}
