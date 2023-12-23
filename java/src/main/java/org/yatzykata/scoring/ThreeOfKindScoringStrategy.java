package org.yatzykata.scoring;

public class ThreeOfKindScoringStrategy extends AbstractNOfKindScoringStrategy {
    @Override
    protected int expectedNumberOfSameSide() {
        return 3;
    }
}
