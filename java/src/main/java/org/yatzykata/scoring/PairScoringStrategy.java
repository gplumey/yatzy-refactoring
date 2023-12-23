package org.yatzykata.scoring;

public class PairScoringStrategy extends AbstractNOfKindScoringStrategy {
    private final static int TWO_SIDES = 2;

    protected PairScoringStrategy() {
        super(TWO_SIDES);
    }

}
