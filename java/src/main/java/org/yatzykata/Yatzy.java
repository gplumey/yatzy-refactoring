package org.yatzykata;

import org.yatzykata.scoring.*;
import org.yatzykata.valueobject.Roll;
import org.yatzykata.valueobject.Score;
import org.yatzykata.valueobject.Side;

public class Yatzy {


    private final ScoringStrategy chanceScoringStrategy;
    private final ScoringStrategy yatzyScoringStrategy;
    private final ScoringStrategy onesScoringStrategy;
    private final ScoringStrategy twosScoringStrategy;
    private final ScoringStrategy threesScoringStrategy;
    private final ScoringStrategy foursScoringStrategy;
    private final ScoringStrategy fivesScoringStrategy;
    private final ScoringStrategy sixesScoringStrategy;

    private final ScoringStrategy pairScoringStrategy;
    private final ScoringStrategy twoPairScoringStrategy;

    private final ScoringStrategy threeOfKingScoringStrategy;
    private final ScoringStrategy fourOfKingScoringStrategy;

    private final ScoringStrategy smallStraightScoringStrategy;
    private final ScoringStrategy largeStraightScoringStrategy;

    private final ScoringStrategy fullHouseScoringStrategy;

    public Yatzy() {
        this.chanceScoringStrategy = new ChanceScoringStrategy();
        this.yatzyScoringStrategy = new YatzyScoringStrategy();
        this.onesScoringStrategy = new SideScoringStrategy(Side.ONE);
        this.twosScoringStrategy = new SideScoringStrategy(Side.TWO);
        this.threesScoringStrategy = new SideScoringStrategy(Side.THREE);
        this.foursScoringStrategy = new SideScoringStrategy(Side.FOUR);
        this.fivesScoringStrategy = new SideScoringStrategy(Side.FIVE);
        this.sixesScoringStrategy = new SideScoringStrategy(Side.SIX);
        this.pairScoringStrategy = new PairScoringStrategy();
        this.twoPairScoringStrategy = new TwoPairScoringStrategy();
        this.threeOfKingScoringStrategy = new ThreeOfKindScoringStrategy();
        this.fourOfKingScoringStrategy = new FourOfKindScoringStrategy();
        this.smallStraightScoringStrategy = new SmallStraightScoringStrategy();
        this.largeStraightScoringStrategy = new LargeStraightScoringStrategy();
        this.fullHouseScoringStrategy = new FullHouseScoringStrategy();
    }

    public Score chance(Roll roll) {
        return chanceScoringStrategy.score(roll);
    }

    public Score yatzy(Roll roll) {
        return yatzyScoringStrategy.score(roll);
    }

    public Score ones(Roll roll) {
        return onesScoringStrategy.score(roll);
    }

    public Score twos(Roll roll) {
        return twosScoringStrategy.score(roll);
    }

    public Score threes(Roll roll) {
        return threesScoringStrategy.score(roll);
    }

    public Score fours(Roll roll) {
        return foursScoringStrategy.score(roll);
    }

    public Score fives(Roll roll) {
        return fivesScoringStrategy.score(roll);
    }

    public Score sixes(Roll roll) {
        return sixesScoringStrategy.score(roll);
    }

    public Score pair(Roll roll) {
        return pairScoringStrategy.score(roll);
    }

    ;

    public Score twoPair(Roll roll) {
        return twoPairScoringStrategy.score(roll);
    }

    public Score threeOfKing(Roll roll) {
        return this.threeOfKingScoringStrategy.score(roll);
    }

    public Score fourOfKing(Roll roll) {
        return this.fourOfKingScoringStrategy.score(roll);
    }

    public Score smallStraight(Roll roll) {
        return this.smallStraightScoringStrategy.score(roll);
    }

    public Score largeStraight(Roll roll) {
        return this.largeStraightScoringStrategy.score(roll);
    }

    public Score fullHouse(Roll roll) {
        return this.fullHouseScoringStrategy.score(roll);
    }

}
