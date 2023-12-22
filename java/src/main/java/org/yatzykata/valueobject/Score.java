package org.yatzykata.valueobject;

public class Score {

    private final int score;

    public Score(int score) {
        if(score < 0) throw new IllegalStateException("score must be a positive integer.");
        this.score = score;
    }

    public int getScore() {
        return score;
    }


    public static Score of(int score) {
        return new Score(score);
    }

    @Override
    public String toString() {
        return "Score{" +
            "score=" + score +
            '}';
    }

}
