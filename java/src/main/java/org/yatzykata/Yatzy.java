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

    private final ScoringStrategy paiScoringStrategy;


    public Yatzy() {
        this.chanceScoringStrategy = new ChanceScoringStrategy();
        this.yatzyScoringStrategy = new YatzyScoringStrategy();
        this.onesScoringStrategy = new SideScoringStrategy(Side.ONE);
        this.twosScoringStrategy = new SideScoringStrategy(Side.TWO);
        this.threesScoringStrategy = new SideScoringStrategy(Side.THREE);
        this.foursScoringStrategy = new SideScoringStrategy(Side.FOUR);
        this.fivesScoringStrategy = new SideScoringStrategy(Side.FIVE);
        this.sixesScoringStrategy = new SideScoringStrategy(Side.SIX);
        this.paiScoringStrategy = new PairScoringStrategy();
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

    public Score pair(Roll roll) { return paiScoringStrategy.score(roll);};


    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}
