package org.yatzykata.valueobject;

import org.yatzykata.error.State;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Roll {

    private final List<Side> sides;

    private final Map<Side, Long> countBySideMap;

    public Roll(Collection<Side> sides) {
        State.requireNonNull(sides, "sides most not be null");
        if (sides.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("All sides must not be null");
        }
        this.sides = List.copyOf(sides); // sides is a unmodifiable List
        countBySideMap = this.sides.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Collection<Side> read() {
        return sides;
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

    public int countBySide(Side side) {
        return countBySideMap.getOrDefault(side, 0L).intValue();
    }

    public boolean areAllSideEqual() {
        //TODO: fix bug when not present
        return countBySideMap.values().stream().max(Long::compareTo).get() == sides.size();
    }


    private boolean isPair(Map.Entry<Side, Long> sideCountEntry) {
        return sideCountEntry.getValue() >= 2;
    }

    private boolean isAtLeastNTime(int n, Map.Entry<Side, Long> sideCountEntry) {
        return sideCountEntry.getValue() >= n;
    }
    public Collection<Side> pairs() {
        return countBySideMap.entrySet().stream().filter(this::isPair).map(Map.Entry::getKey).toList();
    }

    public Collection<Side> atLeastNTime(int n) {
        return countBySideMap.entrySet().stream()
                             .filter(sideLongEntry -> isAtLeastNTime(n, sideLongEntry))
                             .map(Map.Entry::getKey).toList();
    }
}
