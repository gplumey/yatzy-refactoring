package org.yatzykata.scoring;

import org.yatzykata.valueobject.Category;

public interface ScoringStrategyFactory {
   ScoringStrategy create(Category category);
}
