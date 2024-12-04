package com.jazz_harmony_helper.jazz_harmony_helper_application.scale;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ScaleDegree {
    TONIC(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7);

    private static final Map<Integer, ScaleDegree> SCALE_DEGREES = Arrays.stream(values())
           .collect(Collectors.toMap(
                   ScaleDegree::getNumber,
                   Function.identity()
           ));

    public static ScaleDegree fromNumber(int number) {
        if (!SCALE_DEGREES.containsKey(number)) {
            throw new IllegalArgumentException(number + " is not a valid scale degree");
        }
        return SCALE_DEGREES.get(number);
    }

    private final int number;

    ScaleDegree(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
