package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSet;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicClassification;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicFunction;

import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.Set;

public class HarmonicLibrary {
    private SequencedMap<HarmonicClassification, SequencedSet<HarmonicAnalysisDrivenChordSet>> analysesByClassification;
    private SequencedMap<HarmonicFunction, SequencedSet<HarmonicAnalysisDrivenChordSet>> analysesByFunction;

    protected HarmonicLibrary(Set<HarmonicAnalysisDrivenChordSet> analyses) {
        init(analyses);
    }

    private void init(Set<HarmonicAnalysisDrivenChordSet> analyses) {
        // organize analyses here
    }

}
