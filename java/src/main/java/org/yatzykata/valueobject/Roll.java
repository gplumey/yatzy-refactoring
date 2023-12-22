package org.yatzykata.valueobject;

import org.yatzykata.error.State;

import java.util.*;

public class Roll {

    private final List<Side> sides;

    public Roll(Collection<Side> sides) {
        State.requireNonNull(sides, "sides most not be null");
        if (sides.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("All sides must not be null");
        }
        this.sides = List.copyOf(sides);
    }

    public Collection<Side> read() {
        return Collections.unmodifiableList(sides);
    }


    public static Roll of(Side... sides) {
        return new Roll(Arrays.stream(sides).toList());
    }

    @Override
    public String toString() {
        return "Roll{" +
            "sides=" + sides +
            '}';
    }

    public long countBySide(Side side) {
        return 1;
    }
}
