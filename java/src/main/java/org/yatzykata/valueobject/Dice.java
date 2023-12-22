package org.yatzykata.valueobject;

import org.yatzykata.error.State;

public class Dice {

    private Side readSide;

    public Dice(Side readSide) {
        this.readSide = State.requireNonNull(readSide, "readSide is required");
    }

    @Override
    public String toString() {
        return "Dice{" +
            "readSide=" + readSide +
            '}';
    }
}
