package com.jazz_harmony_helper.jazz_harmony_helper_application.scale;

public enum Interval {
    DIMINISHED_TONIC(ScaleDegree.TONIC, 11),
    TONIC(ScaleDegree.TONIC, 0),
    AUGMENTED_TONIC(ScaleDegree.TONIC, 1),
    DIMINISHED_SECOND(ScaleDegree.SECOND, 0),
    MINOR_SECOND(ScaleDegree.SECOND, 1),
    MAJOR_SECOND(ScaleDegree.SECOND, 2),
    AUGMENTED_SECOND(ScaleDegree.SECOND, 3),
    DIMINISHED_THIRD(ScaleDegree.THIRD, 2),
    MINOR_THIRD(ScaleDegree.THIRD, 3),
    MAJOR_THIRD(ScaleDegree.THIRD, 4),
    AUGMENTED_THIRD(ScaleDegree.THIRD, 5),
    DIMINISHED_FOURTH(ScaleDegree.FOURTH, 4),
    PERFECT_FOURTH(ScaleDegree.FOURTH, 5),
    AUGMENTED_FOURTH(ScaleDegree.FOURTH, 6),
    DIMINISHED_FIFTH(ScaleDegree.FIFTH, 6),
    PERFECT_FIFTH(ScaleDegree.FIFTH, 7),
    AUGMENTED_FIFTH(ScaleDegree.FIFTH, 8),
    DIMINISHED_SIXTH(ScaleDegree.SIXTH, 7),
    MINOR_SIXTH(ScaleDegree.SIXTH, 8),
    MAJOR_SIXTH(ScaleDegree.SIXTH, 9),
    AUGMENTED_SIXTH(ScaleDegree.SIXTH, 10),
    DIMINISHED_SEVENTH(ScaleDegree.SEVENTH, 9),
    MINOR_SEVENTH(ScaleDegree.SEVENTH, 10),
    MAJOR_SEVENTH(ScaleDegree.SEVENTH, 11),
    AUGMENTED_SEVENTH(ScaleDegree.SEVENTH, 0);

    private final ScaleDegree scaleDegree;
    private final int canonicalScaleDegree;

    Interval(ScaleDegree scaleDegree, int canonicalScaleDegree) {
        this.scaleDegree = scaleDegree;
        this.canonicalScaleDegree = canonicalScaleDegree;
    }

    public ScaleDegree getScaleDegree() {
        return scaleDegree;
    }

    public int getCanonicalScaleDegree() {
        return canonicalScaleDegree;
    }
}
