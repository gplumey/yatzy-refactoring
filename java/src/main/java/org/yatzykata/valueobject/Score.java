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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

}
