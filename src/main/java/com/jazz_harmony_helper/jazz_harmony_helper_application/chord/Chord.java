package com.jazz_harmony_helper.jazz_harmony_helper_application.chord;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import java.util.Map;
import java.util.SequencedMap;

public class Chord {
    private final ChordAbstract chordAbstract;
    private final String analysis;
    private final SequencedMap<Interval, CanonicalNote> chordTones;
    private final SequencedMap<Interval, CanonicalNote> tensions;
    private final SequencedMap<Interval, CanonicalNote> fullNoteMappings;

    public Chord(
            ChordAbstract chordAbstract,
            String analysis,
            SequencedMap<Interval, CanonicalNote> chordTones,
            SequencedMap<Interval, CanonicalNote> tensions,
            SequencedMap<Interval, CanonicalNote> fullNoteMappings
    ) {
        this.chordAbstract = chordAbstract;
        this.analysis = analysis;
        this.chordTones = chordTones;
        this.tensions = tensions;
        this.fullNoteMappings = fullNoteMappings;
    }

    public ChordAbstract getChordAbstract() {
        return this.chordAbstract;
    }

    public String getAnalysis() {
        return this.analysis;
    }

    public SequencedMap<Interval, CanonicalNote> getChordTones() {
        return chordTones;
    }

    public SequencedMap<Interval, CanonicalNote> getTensions() {
        return tensions;
    }

    public Map<Interval, CanonicalNote> getFullNoteMappings() {
        return fullNoteMappings;
    }
}
