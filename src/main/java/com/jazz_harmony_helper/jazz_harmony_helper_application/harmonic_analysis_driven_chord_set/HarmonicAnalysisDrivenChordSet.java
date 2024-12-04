package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.Chord;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;

import java.util.Set;

public class HarmonicAnalysisDrivenChordSet {
    private final HarmonicAnalysisDrivenChordSetAbstract harmonicAnalysisDrivenChordSetAbstract;
    private final Key key;
    private final Set<Chord> possibleChords;
    private final HarmonicClassification harmonicClassification;
    private final HarmonicFunction harmonicFunction;
    private final String analysis;

    protected HarmonicAnalysisDrivenChordSet(
            HarmonicAnalysisDrivenChordSetAbstract harmonicAnalysisDrivenChordSetAbstract,
            Key key,
            Set<Chord> possibleChords,
            HarmonicClassification harmonicClassification,
            HarmonicFunction harmonicFunction,
            String analysis
    ) {
        this.harmonicAnalysisDrivenChordSetAbstract = harmonicAnalysisDrivenChordSetAbstract;
        this.key = key;
        this.possibleChords = possibleChords;
        this.harmonicClassification = harmonicClassification;
        this.harmonicFunction = harmonicFunction;
        this.analysis = analysis;
    }

    public HarmonicAnalysisDrivenChordSetAbstract getHarmonicAnalysisDrivenChordSetAbstract() {
        return harmonicAnalysisDrivenChordSetAbstract;
    }

    public Key getKey() {
        return key;
    }

    public Set<Chord> getPossibleChords() {
        return possibleChords;
    }

    public HarmonicClassification getHarmonicClassification() {
        return harmonicClassification;
    }

    public HarmonicFunction getHarmonicFunction() {
        return harmonicFunction;
    }



    public String getAnalysis() {
        return analysis;
    }
}
