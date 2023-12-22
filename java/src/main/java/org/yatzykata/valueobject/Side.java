package org.yatzykata.valueobject;

public enum Side {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    private final int number;

    Side(int number) {
        this.number = number;
    }



    public int number() {
        return number;
    }

    public Score score() {
        return Score.of(this.number);
    }
}
