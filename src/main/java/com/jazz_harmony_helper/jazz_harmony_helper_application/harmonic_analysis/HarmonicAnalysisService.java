package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.Chord;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicLibrary;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HarmonicAnalysisService {
    private final Map<Integer, Map<Key, Set<Chord>>> canonicalNotesToContainingChords = new HashMap<>();
    private final HarmonicLibrary harmonicLibrary;

    public HarmonicAnalysisService(
            HarmonicLibrary harmonicLibrary
    ) {
        this.harmonicLibrary = harmonicLibrary;
        init();
    }

    private void init() {
        for (int i = 0; i < 12; i++) {
            canonicalNotesToContainingChords.put(i, new HashMap<>());
//            for (Key key : keyFactory.getAll()) {
//                canonicalNotesToContainingChords.get(i).put(key, new HashSet<>());
//            }
        }

        for (Chord chord : new ArrayList<Chord>()) {
//            for (Integer canonicalNote : chord.getCanonicalNoteSet()) {
//                canonicalNotesToContainingChords.get(canonicalNote).add(chord);
//            }
        }
    }
}
