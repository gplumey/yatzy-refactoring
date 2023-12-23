package org.yatzykata.valueobject;

import java.util.Objects;

public record Score(int value) {
    public final static Score ZERO = Score.of(0);
    public final static Score YATZY = Score.of(50);

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
        Objects.requireNonNull(other);
        return new Score(this.value() + other.value());
    }

    public Score multiple(int multiplier) {
        return new Score(Math.multiplyExact(this.value, multiplier));
    }
}
