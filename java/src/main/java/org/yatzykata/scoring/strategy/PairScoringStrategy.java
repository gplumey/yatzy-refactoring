package org.yatzykata.scoring.strategy;

public class PairScoringStrategy extends AbstractNOfKindScoringStrategy {
    private final static int TWO_SIDES = 2;

    public PairScoringStrategy() {
        super(TWO_SIDES);
    }

}
