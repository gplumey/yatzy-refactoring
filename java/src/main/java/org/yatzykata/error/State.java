package org.yatzykata.error;

public class State {

    public static <T> T requireNonNull(T value, String message) {
        if (value == null) throw new IllegalStateException(message);
        return value;
    }
}
