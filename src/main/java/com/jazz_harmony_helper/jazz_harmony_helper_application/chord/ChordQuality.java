package com.jazz_harmony_helper.jazz_harmony_helper_application.chord;

import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;

public enum ChordQuality {
    MAJOR_SEVENTH_CHORD(
            "Maj7",
            Arrays.asList(
                    TONIC,
                    MAJOR_THIRD,
                    PERFECT_FIFTH,
                    MAJOR_SEVENTH
            )
    ),
    MAJOR_SIXTH_CHORD(
            "6",
            Arrays.asList(
                    TONIC,
                    MAJOR_THIRD,
                    PERFECT_FIFTH,
                    MAJOR_SIXTH
            )
    ),
    DOMINANT_SEVENTH_CHORD(
            "7",
            Arrays.asList(
                    TONIC,
                    MAJOR_THIRD,
                    PERFECT_FIFTH,
                    MINOR_SEVENTH
            )
    ),
    DOMINANT_SEVENTH_FLAT_FIVE_CHORD(
            "7b5",
            Arrays.asList(
                    TONIC,
                    MAJOR_THIRD,
                    DIMINISHED_FIFTH,
                    MINOR_SEVENTH
            )
    ),
    DOMINANT_SUS_FOUR_CHORD(
            "7sus4",
            Arrays.asList(
                    TONIC,
                    PERFECT_FOURTH,
                    PERFECT_FIFTH,
                    MINOR_SEVENTH
            )
    ),
    MINOR_CHORD(
            "-",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    PERFECT_FIFTH
            )
    ),
    MINOR_SEVENTH_CHORD(
            "-7",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    PERFECT_FIFTH,
                    MINOR_SEVENTH
            )
    ),
    MINOR_SIXTH_CHORD(
            "-6",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    PERFECT_FIFTH,
                    MAJOR_SIXTH
            )
    ),
    MINOR_SEVEN_FLAT_FIVE_CHORD(
            "-7b5",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    DIMINISHED_FIFTH,
                    MINOR_SEVENTH
            )
    ),
    DIMINISHED_SEVENTH_CHORD(
            "°7",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    DIMINISHED_FIFTH,
                    DIMINISHED_SEVENTH
            )
    ),
    MINOR_MAJOR_SEVENTH_CHORD(
            "-Maj7",
            Arrays.asList(
                    TONIC,
                    MINOR_THIRD,
                    PERFECT_FIFTH,
                    MAJOR_SEVENTH
            )
    ),
    AUGMENTED_MAJOR_SEVENTH_CHORD(
            "+Maj7",
            Arrays.asList(
                    TONIC,
                    MAJOR_THIRD,
                    AUGMENTED_FIFTH,
                    MAJOR_SEVENTH
            )
    );

    private final String representation;
    private final SequencedSet<Interval> intervals;

    ChordQuality(String representation, List<Interval> intervals) {
        this.representation = representation;
        this.intervals = new LinkedHashSet<>(intervals);
    }

    public SequencedSet<Interval> getIntervals() {
        return this.intervals;
    }

    public String getRepresentation() {
        return this.representation;
    }
}
