package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library;

import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.KeyRelativeModality;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.MajorKeySignature;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;

import java.util.LinkedHashMap;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.Set;

public class KeyLibrary {
    private final SequencedMap<CanonicalNote, SequencedMap<KeyRelativeModality, Key>> keysByRoot = new LinkedHashMap<>();
    private final SequencedMap<MajorKeySignature, SequencedSet<Key>> keysByKeySignature = new LinkedHashMap<>();

    protected KeyLibrary(Set<Key> keys) {
        init(keys);
    }

    private void init(Set<Key> keys) {
        // Organize all keys into respective maps here
    }

    public SequencedMap<CanonicalNote, SequencedMap<KeyRelativeModality, Key>> getKeysByRoot() {
        return this.keysByRoot;
    }

    public SequencedMap<MajorKeySignature, SequencedSet<Key>> getKeysByKeySignature() {
        return this.keysByKeySignature;
    }
}
