package org.yatzykata.scoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

@DisplayName("Scoring rule for the 'Chance' category")
class ChangeScoreStrategyTest {

    ChanceScoringStrategy chanceScoringStrategy;

    @BeforeEach
    void setup() {
        chanceScoringStrategy = new ChanceScoringStrategy();
    }

    static Stream<Arguments> calculateScore_returns_sum() {
        return Stream.of(
            Arguments.of(Score.of(1), Roll.of(Side.ONE)),
            Arguments.of(Score.of(3), Roll.of(Side.ONE, Side.TWO)),
            Arguments.of(Score.of(15), Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE)),
            Arguments.of(Score.of(16), Roll.of(Side.THREE, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE))
        );
    }

    @ParameterizedTest
    @MethodSource
    void calculateScore_returns_sum(Score expectedScore, Roll roll) {
        var calculatedScore = chanceScoringStrategy.score(roll);
        Assertions.assertEquals(calculatedScore, expectedScore);
    }
}
