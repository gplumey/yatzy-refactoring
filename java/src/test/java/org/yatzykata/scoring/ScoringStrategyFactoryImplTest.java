package org.yatzykata.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.yatzykata.valueobject.Category;

import static org.junit.jupiter.api.Assertions.*;

class ScoringStrategyFactoryImplTest {

    ScoringStrategyFactoryImpl scoringStrategyFactory;

    @BeforeEach
    void setup() {
        scoringStrategyFactory = new ScoringStrategyFactoryImpl();
    }

    @ParameterizedTest
    @EnumSource(Category.class)
    void create_returns_strategy_for_all_categories(Category category) {
        ScoringStrategy scoringStrategy = scoringStrategyFactory.create(category);
        assertNotNull(scoringStrategy);
    }

    @Test
    void create_throws_when_category_is_null() {
        Executable exec = () -> scoringStrategyFactory.create(null);
        Throwable thrown = assertThrows(NullPointerException.class, exec);
        assertEquals("category must not be null", thrown.getMessage());
    }
}
