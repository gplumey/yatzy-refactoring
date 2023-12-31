package org.yatzykata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.yatzykata.scoring.ScoringStrategyFactoryImpl;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyScoringRulesTest {

    YatzyScoringRules yatzyScoringRules;

    @BeforeEach
    public void setup() {
        this.yatzyScoringRules = new YatzyScoringRules(new ScoringStrategyFactoryImpl());
    }

    @Nested
    class ChanceScore {

        @Test
        void chance_returns_15_for_2_3_4_5_1() {
            var roll = Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE);
            var score = yatzyScoringRules.chance(roll);
            assertEquals(Score.of(15), score);
        }

        @Test
        void chance_returns_16_for_2_3_4_5_1() {
            var roll = Roll.of(Side.THREE, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE);
            var score = yatzyScoringRules.chance(roll);
            assertEquals(Score.of(16), score);
        }
    }

    @Nested
    class YatzyScore {
        static Stream<Arguments> yatzy_returns_50_when_all_dice_are_same() {
            return Stream.of(
                Arguments.of(Roll.of(Side.FOUR, Side.FOUR, Side.FOUR, Side.FOUR, Side.FOUR)),
                Arguments.of(Roll.of(Side.SIX, Side.SIX, Side.SIX, Side.SIX, Side.SIX))
            );
        }

        @ParameterizedTest
        @MethodSource
        void yatzy_returns_50_when_all_dice_are_same(Roll roll) {
            assertEquals(Score.YATZY, yatzyScoringRules.yatzy(roll));
        }

        static Stream<Arguments> yatzy_returns_0_when_one_dice_not_same() {
            return Stream.of(
                Arguments.of(Roll.of(Side.ONE, Side.ONE, Side.ONE, Side.TWO, Side.ONE)),
                Arguments.of(Roll.of(Side.SIX, Side.SIX, Side.SIX, Side.SIX, Side.THREE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void yatzy_returns_0_when_one_dice_not_same(Roll notYatzyRoll) {
            assertEquals(Score.ZERO, yatzyScoringRules.yatzy(notYatzyRoll));
        }
    }

    @Nested
    class OnesScore {
        static Stream<Arguments> ones_returns_count_of_sides_ONE_multiply_by_1() {
            return Stream.of(
                Arguments.of(Score.of(1), Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.of(2), Roll.of(Side.ONE, Side.TWO, Side.ONE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.SIX, Side.TWO, Side.TWO, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.of(4), Roll.of(Side.ONE, Side.TWO, Side.ONE, Side.ONE, Side.ONE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void ones_returns_count_of_sides_ONE_multiply_by_1(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.ones(roll));
        }
    }

    @Nested
    class TwosScore {
        static Stream<Arguments> twos_returns_count_of_sides_TWO_multiply_by_2() {
            return Stream.of(
                Arguments.of(Score.of(4), Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.TWO, Side.SIX)),
                Arguments.of(Score.of(10), Roll.of(Side.TWO, Side.TWO, Side.TWO, Side.TWO, Side.TWO)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.THREE, Side.FOUR, Side.FIVE, Side.FIVE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void twos_returns_count_of_sides_TWO_multiply_by_2(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.twos(roll));
        }
    }

    @Nested
    class ThreesScore {
        static Stream<Arguments> threes_returns_count_of_sides_THREE_multiply_by_3() {
            return Stream.of(
                Arguments.of(Score.of(6), Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.TWO, Side.THREE)),
                Arguments.of(Score.of(12), Roll.of(Side.TWO, Side.THREE, Side.THREE, Side.THREE, Side.THREE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.TWO, Side.FOUR, Side.FIVE, Side.FIVE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void threes_returns_count_of_sides_THREE_multiply_by_3(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.threes(roll));
        }
    }

    @Nested
    class FoursScore {
        static Stream<Arguments> fours_returns_count_of_sides_FOUR_multiply_by_4() {
            return Stream.of(
                Arguments.of(Score.of(12), Roll.of(Side.FOUR, Side.FOUR, Side.FOUR, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(8), Roll.of(Side.FOUR, Side.FOUR, Side.FIVE, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(4), Roll.of(Side.FOUR, Side.FIVE, Side.FIVE, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FIVE, Side.SIX))
            );
        }

        @ParameterizedTest
        @MethodSource
        void fours_returns_count_of_sides_FOUR_multiply_by_4(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.fours(roll));
        }
    }

    @Nested
    class FivesScore {
        static Stream<Arguments> fives_returns_count_of_sides_FIVE_multiply_by_5() {
            return Stream.of(
                Arguments.of(Score.of(10), Roll.of(Side.FOUR, Side.FOUR, Side.FOUR, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(15), Roll.of(Side.FOUR, Side.FOUR, Side.FIVE, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(20), Roll.of(Side.FOUR, Side.FIVE, Side.FIVE, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FOUR))
            );
        }

        @ParameterizedTest
        @MethodSource
        void fives_returns_count_of_sides_FIVE_multiply_by_5(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.fives(roll));
        }
    }

    @Nested
    class SixesScore {
        static Stream<Arguments> fives_returns_count_of_sides_SIXE_multiply_by_6() {
            return Stream.of(
                Arguments.of(Score.of(0), Roll.of(Side.FOUR, Side.FOUR, Side.FOUR, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(6), Roll.of(Side.FOUR, Side.FOUR, Side.SIX, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(18), Roll.of(Side.SIX, Side.FIVE, Side.SIX, Side.SIX, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void fives_returns_count_of_sides_SIXE_multiply_by_6(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.sixes(roll));
        }
    }

    @Nested
    class PairScore {
        static Stream<Arguments> pair_scores_the_sum_of_the_two_highest_matching_dice() {
            return Stream.of(
                Arguments.of(Score.of(6), Roll.of(Side.THREE, Side.FOUR, Side.THREE, Side.FIVE, Side.SIX)),
                Arguments.of(Score.of(10), Roll.of(Side.FIVE, Side.THREE, Side.THREE, Side.THREE, Side.FIVE)),
                Arguments.of(Score.of(12), Roll.of(Side.FIVE, Side.THREE, Side.SIX, Side.SIX, Side.FIVE)),
                Arguments.of(Score.of(6), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.FOUR, Side.ONE)),
                Arguments.of(Score.of(6), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE, Side.ONE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE))

            );
        }

        @ParameterizedTest
        @MethodSource
        void pair_scores_the_sum_of_the_two_highest_matching_dice(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.pair(roll));
        }
    }

    @Nested
    class TwoPairScore {
        static Stream<Arguments> two_pair_scores_the_sum_of_the_matching_dice_if_two_pairs_exit() {
            return Stream.of(
                Arguments.of(Score.of(16), Roll.of(Side.THREE, Side.THREE, Side.FIVE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.of(16), Roll.of(Side.THREE, Side.THREE, Side.FIVE, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.ONE, Side.ONE, Side.TWO, Side.THREE, Side.FOUR)),
                Arguments.of(Score.ZERO, Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE, Side.ONE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void two_pair_scores_the_sum_of_the_matching_dice_if_two_pairs_exit(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.twoPair(roll));
        }
    }

    @Nested
    class ThreeOfKindScore {
        static Stream<Arguments> three_of_a_kind_scores_the_sum_of_three_matching_dice_if_exit() {
            return Stream.of(
                Arguments.of(Score.of(9), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.of(15), Roll.of(Side.FIVE, Side.THREE, Side.FIVE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.of(9), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.THREE, Side.THREE, Side.FOUR, Side.FIVE, Side.SIX)),
                Arguments.of(Score.of(9), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE, Side.THREE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void three_of_a_kind_scores_the_sum_of_three_matching_dice_if_exit(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.threeOfKing(roll));
        }
    }

    @Nested
    class FourOfKindScore {
        static Stream<Arguments> four_of_a_kind_scores_the_sum_of_four_matching_dice_if_exit() {
            return Stream.of(
                Arguments.of(Score.of(12), Roll.of(Side.THREE, Side.THREE, Side.THREE, Side.THREE, Side.FIVE)),
                Arguments.of(Score.of(20), Roll.of(Side.FIVE, Side.FIVE, Side.FIVE, Side.FOUR, Side.FIVE)),
                Arguments.of(Score.ZERO, Roll.of(Side.TWO, Side.TWO, Side.TWO, Side.FIVE, Side.FIVE)),
                Arguments.of(Score.of(8), Roll.of(Side.TWO, Side.TWO, Side.TWO, Side.TWO, Side.TWO))
            );
        }

        @ParameterizedTest
        @MethodSource
        void four_of_a_kind_scores_the_sum_of_four_matching_dice_if_exit(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.fourOfKing(roll));
        }
    }

    @Nested
    class SmallStraightScore {
        static Stream<Arguments> smallStraight_scores_15() {
            return Stream.of(
                Arguments.of(Roll.of(Side.ONE, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE)),
                Arguments.of(Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE))
            );
        }

        @ParameterizedTest
        @MethodSource
        void smallStraight_scores_15(Roll roll) {
            assertEquals(Score.SMALL_STRAIGHT, yatzyScoringRules.smallStraight(roll));
        }

        @Test
        void smallStraight_scores_ZERO_not_read() {
            Roll notSmallStraightRoll = Roll.of(Side.ONE, Side.TWO, Side.TWO, Side.FOUR, Side.FIVE);
            assertEquals(Score.ZERO, yatzyScoringRules.smallStraight(notSmallStraightRoll));
        }
    }

    @Nested
    class LargeStraightScore {
        static Stream<Arguments> largeStraight_scores_LARGE_STRAIGHT() {
            return Stream.of(
                Arguments.of(Roll.of(Side.SIX, Side.TWO, Side.THREE, Side.FOUR, Side.FIVE)),
                Arguments.of(Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.SIX))
            );
        }

        @ParameterizedTest
        @MethodSource
        void largeStraight_scores_LARGE_STRAIGHT(Roll roll) {
            assertEquals(Score.LARGE_STRAIGHT, yatzyScoringRules.largeStraight(roll));
        }

        @Test
        void largeStraight_scores_ZERO_not_read() {
            Roll notSmallStraightRoll = Roll.of(Side.ONE, Side.TWO, Side.TWO, Side.FOUR, Side.FIVE);
            assertEquals(Score.ZERO, yatzyScoringRules.largeStraight(notSmallStraightRoll));
        }
    }

    @Nested
    class FullHouseScore {
        static Stream<Arguments> fullHouse_scores_the_sum_of_all_dice() {
            return Stream.of(
                Arguments.of(Score.of(18), Roll.of(Side.SIX, Side.TWO, Side.TWO, Side.TWO, Side.SIX)),
                Arguments.of(Score.of(8),Roll.of(Side.ONE, Side.TWO, Side.ONE, Side.TWO, Side.TWO))
            );
        }

        @ParameterizedTest
        @MethodSource
        void fullHouse_scores_the_sum_of_all_dice(Score expectedScore, Roll roll) {
            assertEquals(expectedScore, yatzyScoringRules.fullHouse(roll));
        }
        static Stream<Arguments> fullHouse_scores_ZERO_when_not_read() {
            return Stream.of(
                Arguments.of(Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.SIX)),
                Arguments.of(Roll.of(Side.TWO, Side.TWO, Side.THREE, Side.THREE, Side.FOUR)),
                Arguments.of(Roll.of(Side.FOUR, Side.FOUR, Side.FOUR, Side.FOUR, Side.FOUR))
            );
        }
        @ParameterizedTest
        @MethodSource
        void fullHouse_scores_ZERO_when_not_read(Roll roll) {
            assertEquals(Score.ZERO, yatzyScoringRules.fullHouse(roll));
        }
    }

}
