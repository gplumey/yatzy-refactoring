package org.yatzykata.scoring;

import org.yatzykata.scoring.strategy.*;
import org.yatzykata.valueobject.Category;
import org.yatzykata.valueobject.Side;

import java.util.Objects;

public class ScoringStrategyFactoryImpl implements ScoringStrategyFactory {
    @Override
    public ScoringStrategy create(Category category) {
        Objects.requireNonNull(category, "category must not be null");
        return switch (category) {
            case CHANCE -> new ChanceScoringStrategy();
            case YATZY -> new YatzyScoringStrategy();
            case ONES -> new SideScoringStrategy(Side.ONE);
            case TWOS -> new SideScoringStrategy(Side.TWO);
            case THREES -> new SideScoringStrategy(Side.THREE);
            case FOURS -> new SideScoringStrategy(Side.FOUR);
            case FIVES -> new SideScoringStrategy(Side.FIVE);
            case SIXES -> new SideScoringStrategy(Side.SIX);
            case PAIR -> new PairScoringStrategy();
            case TWO_PAIR -> new TwoPairScoringStrategy();
            case THREE_OF_A_KIND -> new ThreeOfKindScoringStrategy();
            case FOUR_OF_A_KIND -> new FourOfKindScoringStrategy();
            case SMALL_STRAIGHT -> new SmallStraightScoringStrategy();
            case LARGE_STRAIGHT -> new LargeStraightScoringStrategy();
            case FULLHOUSE -> new FullHouseScoringStrategy();
        };
    }
}
