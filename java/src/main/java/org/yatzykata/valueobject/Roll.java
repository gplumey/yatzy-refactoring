package org.yatzykata.valueobject;

import org.yatzykata.error.State;

import java.util.*;

public class Roll {

    private final List<Dice> dices;

    public Roll(Collection<Dice> dices) {
        State.requireNonNull(dices, "dices most not be null");
        if (dices.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("All dices must not be null");
        }
        this.dices = List.copyOf(dices);
    }

    public Collection<Dice> dices() {
        return Collections.unmodifiableList(dices);
    }

    public static Roll of(Dice... dices) {
        return new Roll(Arrays.stream(dices).toList());
    }
    public static Roll of(Side... sides) {
        var dices = sides != null ? Arrays.stream(sides).map(Dice::new).toList(): null;
        return new Roll(dices);
    }
    @Override
    public String toString() {
        return "Roll{" +
            "dices=" + dices +
            '}';
    }
}
