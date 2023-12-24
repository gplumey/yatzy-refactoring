package org.yatzykata.valueobject;

import org.yatzykata.error.State;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Roll {

    public  record CounterSideTuple(int count, Side side) {

        static CounterSideTuple of(Map.Entry<Side, Long> entry) {
            return new CounterSideTuple(entry.getValue().intValue(), entry.getKey());
        }
    }

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

    public List<CounterSideTuple> counterSideTuples() {
        return countBySideMap.entrySet().stream().map(CounterSideTuple::of).toList();
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
        return countBySideMap.values().stream().max(Long::compareTo).orElse(-1L) == sides.size();
    }

    public Collection<Side> atLeastNTime(int n) {
        return countBySideMap.entrySet().stream()
                             .filter(sideCountEntry -> sideCountEntry.getValue() >= n)
                             .map(Map.Entry::getKey).toList();
    }
}
