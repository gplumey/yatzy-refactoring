package org.yatzykata.valueobject;

public record Score(int value) {

    public Score {
        if (value < 0) throw new IllegalStateException("value must be a positive integer.");
    }


    public static Score of(int score) {
        return new Score(score);
    }

    @Override
    public String toString() {
        return "Score{" +
            "value=" + value +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return value == score1.value;
    }

    public Score sum(Score other) {
        return null;
    }
}
