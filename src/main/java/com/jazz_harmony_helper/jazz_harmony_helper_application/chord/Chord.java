package com.jazz_harmony_helper.jazz_harmony_helper_application.chord;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import java.util.Map;
import java.util.SequencedMap;

public class Chord {
    private final ChordAbstract chordAbstract;
    private final SequencedMap<Interval, CanonicalNote> fullNoteMappings;

    public Chord(
            ChordAbstract chordAbstract,
            SequencedMap<Interval, CanonicalNote> fullNoteMappings
    ) {
        this.chordAbstract = chordAbstract;
        this.fullNoteMappings = fullNoteMappings;
    }

    public ChordAbstract getChordAbstract() {
        return this.chordAbstract;
    }

    public Map<Interval, CanonicalNote> getFullNoteMappings() {
        return fullNoteMappings;
    }
}
