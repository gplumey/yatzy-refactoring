package org.yatzykata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    Yatzy yatzy;

    @BeforeEach
    public void setup() {
        this.yatzy = new Yatzy();
    }

    @Nested
    class ChanceScore {

        @Test
        void chance_returns_15_for_2_3_4_5_1() {
            var roll = Roll.of(Side.TWO, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE);
            var score = yatzy.chance(roll);
            assertEquals(Score.of(15), score);
        }

        @Test
        void chance_returns_16_for_2_3_4_5_1() {
            var roll = Roll.of(Side.THREE, Side.THREE, Side.FOUR, Side.FIVE, Side.ONE);
            var score = yatzy.chance(roll);
            assertEquals(Score.of(16), score);
        }
    }

    @Test
    public void chance_scores_the_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void yatzy_scores_50_when_all_dice_are_same_number() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void ones_scores_the_sum_of_all_dice_equals_to_1() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos_scores_the_sum_of_all_dice_equals_to_2() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
        assertEquals(0, Yatzy.twos(1, 3, 4, 5, 6));
    }

    @Test
    public void threes_scores_the_sum_of_all_dice_equals_to_3() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
        assertEquals(0, Yatzy.threes(1, 2, 4, 5, 6));
    }

    @Test
    public void fours_scores_the_sum_of_all_dice_equals_to_4() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).fours());
    }

    @Test
    public void fives_scores_the_sum_of_all_dice_equals_to_5() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
        assertEquals(0, new Yatzy(1, 2, 3, 4, 6).fives());
    }

    @Test
    public void sixes_scores_the_sum_of_all_dice_equals_to_6() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
        assertEquals(0, new Yatzy(1, 2, 3, 4, 5).sixes());
    }

    @Test
    public void pair_scores_the_sum_of_the_two_highest_matching_dice() {
        assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5));
        assertEquals(0, Yatzy.score_pair(1, 2, 3, 4, 5));
        assertEquals(6, Yatzy.score_pair(3, 3, 3, 4, 1));
        assertEquals(6, Yatzy.score_pair(3, 3, 3, 3, 1));
    }

    @Test
    public void two_pair_scores_the_sum_of_the_matching_dice_if_two_pairs_exit() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5));
        assertEquals(0, Yatzy.two_pair(1, 1, 2, 3, 4));
        assertEquals(0, Yatzy.two_pair(3, 3, 3, 3, 1));
    }

    @Test
    public void three_of_a_kind_scores_the_sum_of_three_matching_dice_if_exit() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(0, Yatzy.three_of_a_kind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void four_of_a_kind_scores_the_sum_of_four_matching_dice_if_exit() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(0, Yatzy.four_of_a_kind(2, 2, 2, 5, 5));
        assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 2));
    }

    @Test
    /**
     * smallStraight is when dice read 1,2,3,4,5.
     */
    public void smallStraight_scores_15() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    /**
     * smallStraight is when dice read 2,3,4,5,6.
     */
    public void largeStraight_scores_20() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    /**
     * smallStraight is when dice are two of a kind and three of a kind.
     */
    public void fullHouse_scores_the_sum_of_all_dice() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4));
    }
}
