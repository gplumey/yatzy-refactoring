package org.yatzykata.scoring;

public class FourOfKindScoringStrategy extends AbstractNOfKindScoringStrategy {
    private final static int FOUR_SIDES = 4;

    protected FourOfKindScoringStrategy() {
        super(FOUR_SIDES);
    }
}
