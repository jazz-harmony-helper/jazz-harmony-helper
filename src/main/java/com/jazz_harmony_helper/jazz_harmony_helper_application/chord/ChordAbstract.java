package com.jazz_harmony_helper.jazz_harmony_helper_application.chord;

import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;

public enum ChordAbstract {
    GENERAL_MAJOR_SEVENTH(
            ChordScale.MAJOR,
            ChordQuality.MAJOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.MAJOR_SIXTH
            )
    ),
    GENERAL_MAJOR_SIXTH(
            ChordScale.MAJOR,
            ChordQuality.MAJOR_SIXTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.MAJOR_SEVENTH
            )
    ),
    GENERAL_DORIAN_MINOR_SEVENTH(
            ChordScale.DORIAN,
            ChordQuality.MINOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH
            )
    ),
    GENERAL_DORIAN_MINOR_SIXTH(
            ChordScale.DORIAN,
            ChordQuality.MINOR_SIXTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH,
                    Interval.MINOR_SEVENTH
            )
    ),
    GENERAL_PHRYGIAN_MINOR_SEVENTH(
            ChordScale.PHRYGIAN,
            ChordQuality.MINOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.PERFECT_FOURTH
            )
    ),
    GENERAL_LYDIAN_MAJOR_SEVENTH(
            ChordScale.LYDIAN,
            ChordQuality.MAJOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.AUGMENTED_FOURTH,
                    Interval.MAJOR_SIXTH
            )
    ),
    GENERAL_LYDIAN_MAJOR_SIXTH(
            ChordScale.LYDIAN,
            ChordQuality.MAJOR_SIXTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.AUGMENTED_FOURTH,
                    Interval.MAJOR_SEVENTH
            )
    ),
    GENERAL_MIXOLYDIAN_DOMINANT_SEVENTH(
            ChordScale.MIXOLYDIAN,
            ChordQuality.DOMINANT_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.MAJOR_SIXTH
            )
    ),
    GENERAL_MIXOLYDIAN_DOMINANT_SEVENTH_SUS_FOUR(
            ChordScale.MIXOLYDIAN,
            ChordQuality.DOMINANT_SUS_FOUR_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.MAJOR_SIXTH
            )
    ),
    DOMINANT_SEVENTH_MINOR_TARGET(
            ChordScale.DOMINANT_SEVENTH_MINOR_TARGET,
            ChordQuality.DOMINANT_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MINOR_SECOND,
                    Interval.AUGMENTED_SECOND,
                    Interval.MINOR_SIXTH
            )
    ),
    DOMINANT_SEVENTH_ALTERED_DOMINANT(
            ChordScale.ALTERED_DOMINANT,
            ChordQuality.DOMINANT_SEVENTH_FLAT_FIVE_CHORD,
            Arrays.asList(
                    Interval.MINOR_SECOND,
                    Interval.AUGMENTED_SECOND,
                    Interval.MINOR_SIXTH
            )
    ),
    DOMINANT_SEVENTH_SYMMETRIC_DOMINANT(
            ChordScale.SYMMETRIC_DOMINANT_SCALE,
            ChordQuality.DOMINANT_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MINOR_SECOND,
                    Interval.AUGMENTED_SECOND,
                    Interval.AUGMENTED_FOURTH,
                    Interval.MAJOR_SIXTH
            )
    ),
    DOMINANT_SEVENTH_LYDIAN_DOMINANT(
            ChordScale.LYDIAN_DOMINANT,
            ChordQuality.DOMINANT_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.AUGMENTED_FOURTH,
                    Interval.MAJOR_SIXTH
            )
    ),
    GENERAL_MIXOLYDIAN_MAJOR_SIXTH(
            ChordScale.MIXOLYDIAN,
            ChordQuality.MAJOR_SIXTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.MINOR_SEVENTH
            )
    ),
    GENERAL_AEOLIAN_MINOR_CHORD(
            ChordScale.AEOLIAN,
            ChordQuality.MINOR_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH,
                    Interval.MINOR_SEVENTH
            )
    ),
    GENERAL_AEOLIAN_MINOR_SEVENTH(
            ChordScale.AEOLIAN,
            ChordQuality.MINOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH
            )
    ),
    GENERAL_LOCRIAN_MINOR_SEVEN_FLAT_FIVE(
            ChordScale.LOCRIAN,
            ChordQuality.MINOR_SEVEN_FLAT_FIVE_CHORD,
            Arrays.asList(
                    Interval.PERFECT_FOURTH,
                    Interval.MINOR_SIXTH
            )
    ),
    MINOR_MAJOR_SEVENTH(
            ChordScale.MELODIC_MINOR_ASCENDING,
            ChordQuality.MINOR_MAJOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH,
                    Interval.MAJOR_SIXTH
            )
    ),
    AUGMENTED_MAJOR_SEVENTH(
            ChordScale.LYDIAN_AUGMENTED,
            ChordQuality.AUGMENTED_MAJOR_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.AUGMENTED_FOURTH
            )
    ),
    DIMINISHED_SEVENTH_CHORD(
            ChordScale.SYMMETRIC_DIMINISHED,
            ChordQuality.DIMINISHED_SEVENTH_CHORD,
            Arrays.asList(
                    Interval.MAJOR_SECOND,
                    Interval.PERFECT_FOURTH,
                    Interval.MINOR_SIXTH,
                    Interval.MAJOR_SEVENTH
            )
    );

    private final ChordScale chordScale;
    private final ChordQuality chordQuality;
    private final SequencedSet<Interval> tensions;

    ChordAbstract(
            ChordScale chordScale,
            ChordQuality chordQuality,
            List<Interval> tensions
    ) {
        this.chordScale = chordScale;
        this.chordQuality = chordQuality;
        this.tensions = new LinkedHashSet<>(tensions);
    }

    public ChordScale getChordScale() {
        return this.chordScale;
    }

    public ChordQuality getChordQuality() {
        return this.chordQuality;
    }

    public SequencedSet<Interval> getTensions() {
        return this.tensions;
    }
}
