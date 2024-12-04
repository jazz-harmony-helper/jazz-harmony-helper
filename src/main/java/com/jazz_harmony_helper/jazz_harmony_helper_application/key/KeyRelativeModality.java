package com.jazz_harmony_helper.jazz_harmony_helper_application.key;

import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval.*;

public enum KeyRelativeModality {
    MAJOR(TONIC),
    MINOR(MAJOR_SIXTH),
    DORIAN(MAJOR_SECOND),
    PHRYGIAN(MAJOR_THIRD),
    LYDIAN(PERFECT_FOURTH),
    MIXOLYDIAN(PERFECT_FIFTH),
    AEOLIAN(MAJOR_SIXTH);

    private final Interval modalityDistanceFromRoot;
    
    KeyRelativeModality(Interval modalityDistanceFromRoot) {
        this.modalityDistanceFromRoot = modalityDistanceFromRoot;
    }

    public Interval getModalityDistanceFromRoot() {
        return modalityDistanceFromRoot;
    }
}
