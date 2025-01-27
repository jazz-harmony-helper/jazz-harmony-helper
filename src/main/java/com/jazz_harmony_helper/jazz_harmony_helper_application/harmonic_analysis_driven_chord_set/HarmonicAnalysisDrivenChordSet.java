package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.Chord;

import java.util.Set;

public class HarmonicAnalysisDrivenChordSet {
    private final HarmonicAnalysisDrivenChordSetAbstract harmonicAnalysisDrivenChordSetAbstract;
    private final Set<Chord> chords;

    public HarmonicAnalysisDrivenChordSet(
            HarmonicAnalysisDrivenChordSetAbstract harmonicAnalysisDrivenChordSetAbstract,
            Set<Chord> chords
    ) {
        this.harmonicAnalysisDrivenChordSetAbstract = harmonicAnalysisDrivenChordSetAbstract;
        this.chords = chords;
    }

    public HarmonicAnalysisDrivenChordSetAbstract getHarmonicAnalysisDrivenChordSetAbstract() {
        return harmonicAnalysisDrivenChordSetAbstract;
    }

    public Set<Chord> getChords() {
        return chords;
    }
}
