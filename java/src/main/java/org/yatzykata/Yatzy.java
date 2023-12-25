package org.yatzykata;

import org.yatzykata.scoring.ScoringStrategyFactory;
import org.yatzykata.valueobject.Category;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;

public class Yatzy {

    private final ScoringStrategyFactory scoringStrategyFactory;

    public Yatzy(ScoringStrategyFactory scoringStrategyFactory) {
       this.scoringStrategyFactory = scoringStrategyFactory;
    }

    private Score score(Category category, Roll roll) {
        return scoringStrategyFactory.create(category).score(roll);
    }

    public Score chance(Roll roll) {
        return scoringStrategyFactory.create(Category.CHANCE).score(roll);
    }

    public Score yatzy(Roll roll) {
        return score(Category.YATZY, roll);
    }

    public Score ones(Roll roll) {
        return score(Category.ONES, roll);
    }

    public Score twos(Roll roll) {
        return score(Category.TWOS, roll);
    }

    public Score threes(Roll roll) {
        return score(Category.THREES, roll);
    }

    public Score fours(Roll roll) {
        return score(Category.FOURS, roll);
    }

    public Score fives(Roll roll) {
        return score(Category.FIVES, roll);
    }

    public Score sixes(Roll roll) {
        return score(Category.SIXES, roll);
    }

    public Score pair(Roll roll) {
        return score(Category.PAIR, roll);
    }

    public Score twoPair(Roll roll) {
        return score(Category.TWO_PAIR, roll);
    }

    public Score threeOfKing(Roll roll) {
        return score(Category.THREE_OF_A_KIND, roll);
    }

    public Score fourOfKing(Roll roll) {
        return score(Category.FOUR_OF_A_KIND, roll);
    }

    public Score smallStraight(Roll roll) {
        return score(Category.SMALL_STRAIGHT, roll);
    }

    public Score largeStraight(Roll roll) {
        return score(Category.LARGE_STRAIGHT, roll);
    }

    public Score fullHouse(Roll roll) {
        return score(Category.FULLHOUSE, roll);
    }

}
