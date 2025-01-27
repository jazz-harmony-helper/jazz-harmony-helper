package com.jazz_harmony_helper.jazz_harmony_helper_application.key;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library.HarmonicLibrary;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;

import java.util.Map;

public class Key {
    private final MajorKeySignature majorKeySignature;
    private final KeyRelativeModality modality;
    private final CanonicalNote keyRoot;
    private final Map<Interval, CanonicalNote> noteAbstractMap;
    private HarmonicLibrary harmonicLibrary;

    public Key(
            MajorKeySignature majorKeySignature,
            KeyRelativeModality modality,
            CanonicalNote keyRoot,
            Map<Interval, CanonicalNote> noteAbstractMap
    ) {
        this.majorKeySignature = majorKeySignature;
        this.modality = modality;
        this.keyRoot = keyRoot;
        this.noteAbstractMap = noteAbstractMap;
    }

    public MajorKeySignature getKeySignature() {
        return majorKeySignature;
    }

    public KeyRelativeModality getModality() {
        return modality;
    }

    public CanonicalNote getKeyRoot() {
        return keyRoot;
    }

    public Map<Interval, CanonicalNote> getNoteAbstractMap() {
        return noteAbstractMap;
    }

    public HarmonicLibrary getHarmonicLibrary() {
        return harmonicLibrary;
    }

    public void setHarmonicLibrary(HarmonicLibrary harmonicLibrary) {
        if (this.harmonicLibrary != null) {
            throw new IllegalStateException("Harmonic library already set");
        }
        this.harmonicLibrary = harmonicLibrary;
    }
}
