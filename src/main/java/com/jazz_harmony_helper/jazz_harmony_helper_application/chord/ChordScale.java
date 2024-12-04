package com.jazz_harmony_helper.jazz_harmony_helper_application.chord;

import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import java.util.Arrays;
import java.util.SequencedSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval.*;

public enum ChordScale {
    MAJOR(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MAJOR_SEVENTH
    ),
    DORIAN(
            TONIC,
            MAJOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    PHRYGIAN(
            TONIC,
            MINOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MINOR_SIXTH,
            MINOR_SEVENTH
    ),
    LYDIAN(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MAJOR_SEVENTH
    ),
    MIXOLYDIAN(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    AEOLIAN(
            TONIC,
            MAJOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MINOR_SIXTH,
            MINOR_SEVENTH
    ),
    LOCRIAN(
            TONIC,
            MINOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            DIMINISHED_FIFTH,
            MINOR_SIXTH,
            MINOR_SEVENTH
    ),
    MELODIC_MINOR_ASCENDING(
            TONIC,
            MAJOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MAJOR_SEVENTH
    ),
    LYDIAN_AUGMENTED(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            AUGMENTED_FIFTH,
            MAJOR_SIXTH,
            MAJOR_SEVENTH
    ),
    HARMONIC_MINOR(
            TONIC,
            MAJOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MINOR_SIXTH,
            MAJOR_SEVENTH
    ),
    DOMINANT_SEVENTH_MINOR_TARGET(
            TONIC,
            MINOR_SECOND,
            AUGMENTED_SECOND,
            MAJOR_THIRD,
            PERFECT_FOURTH,
            PERFECT_FIFTH,
            MINOR_SIXTH,
            MINOR_SEVENTH
    ),
    ALTERED_DOMINANT(
            TONIC,
            MINOR_SECOND,
            AUGMENTED_SECOND,
            MAJOR_THIRD,
            DIMINISHED_FIFTH,
            MINOR_SIXTH,
            MINOR_SEVENTH
    ),
    SYMMETRIC_DOMINANT_SCALE(
            TONIC,
            MINOR_SECOND,
            AUGMENTED_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    LYDIAN_FLAT_SEVEN(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    LYDIAN_FLAT_SEVEN_FLAT_9(
            TONIC,
            MINOR_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    LYDIAN_FLAT_SEVEN_SHARP_9(
            TONIC,
            AUGMENTED_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    ),
    SYMMETRIC_DIMINISHED(
            TONIC,
            MAJOR_SECOND,
            MINOR_THIRD,
            PERFECT_FOURTH,
            DIMINISHED_FIFTH,
            MINOR_SIXTH,
            DIMINISHED_SEVENTH,
            MAJOR_SEVENTH
    ),
    LYDIAN_DOMINANT(
            TONIC,
            MAJOR_SECOND,
            MAJOR_THIRD,
            AUGMENTED_FOURTH,
            PERFECT_FIFTH,
            MAJOR_SIXTH,
            MINOR_SEVENTH
    );

    private final SequencedSet<Interval> intervals;

    ChordScale(Interval... intervals) {
        this.intervals = new LinkedHashSet<>(Arrays.asList(intervals));
    }

    public Set<Interval> getIntervals() {
        return this.intervals;
    }
}
