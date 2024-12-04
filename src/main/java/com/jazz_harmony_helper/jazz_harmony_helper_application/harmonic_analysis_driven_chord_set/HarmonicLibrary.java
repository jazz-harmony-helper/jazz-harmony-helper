package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set;

import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.KeyRelativeModality;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.MajorKeySignature;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;

import java.util.HashMap;
import java.util.Map;

public class HarmonicLibrary {
    private final Map<CanonicalNote, Map<KeyRelativeModality, Key>> keysByKeyCenter = new HashMap<>();
    private final Map<MajorKeySignature, Map<KeyRelativeModality, Key>> keysByKeySignature = new HashMap<>();
    private final Map<Key, Map<HarmonicAnalysisDrivenChordSetAbstract, HarmonicAnalysisDrivenChordSet>> harmChordsByKey = new HashMap<>();

    HarmonicLibrary() {

    }

    void register(Key key) {
        keysByKeyCenter.computeIfAbsent(key.getKeyRoot(), k -> new HashMap<>());
        keysByKeyCenter.get(key.getKeyRoot()).put(key.getModality(), key);

        keysByKeySignature.computeIfAbsent(key.getKeySignature(), k -> new HashMap<>());
        keysByKeySignature.get(key.getKeySignature()).put(key.getModality(), key);
    }

    void register(HarmonicAnalysisDrivenChordSet harmChord) {
        harmChordsByKey.putIfAbsent(harmChord.getKey(), new HashMap<>());
        harmChordsByKey.get(harmChord.getKey()).put(harmChord.getHarmonicAnalysisDrivenChordSetAbstract(), harmChord);
    }
}
