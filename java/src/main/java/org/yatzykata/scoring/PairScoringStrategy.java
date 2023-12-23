package org.yatzykata.scoring;

public class PairScoringStrategy extends AbstractNOfKindScoringStrategy {
    @Override
    protected int expectedNumberOfSameSide() {
        return 2;
    }
}
