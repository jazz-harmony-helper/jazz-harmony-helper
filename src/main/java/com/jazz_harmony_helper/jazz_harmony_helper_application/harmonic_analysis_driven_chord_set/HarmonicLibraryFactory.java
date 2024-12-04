package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.Chord;
import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.configuration.NoteResolver;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.KeyFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.KeyRelativeModality;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.MajorKeySignature;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.util.HarmonicAnalysisUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HarmonicLibraryFactory {
    private static HarmonicLibrary HARMONIC_LIBRARY;

    private HarmonicLibraryFactory() {

    }

    public static HarmonicLibrary getHarmonicLibrary() {
        if (HARMONIC_LIBRARY == null) {
            HARMONIC_LIBRARY = builcHarmonicLibrary();
        }
        return HARMONIC_LIBRARY;
    }

    private static HarmonicLibrary builcHarmonicLibrary() {
        // Group HarmonicAnalysisDrivenChordAbstracts by available modality
        Map<KeyRelativeModality, SequencedSet<HarmonicAnalysisDrivenChordSetAbstract>> modalityToAbstractHarms = new HashMap<>();
        for (HarmonicAnalysisDrivenChordSetAbstract abstractHarm : HarmonicAnalysisDrivenChordSetAbstract.values()) {
            for (KeyRelativeModality keyRelativeModality : abstractHarm.getModalityAvailability()) {
                modalityToAbstractHarms.computeIfAbsent(keyRelativeModality, k -> new LinkedHashSet<>());
                modalityToAbstractHarms.get(keyRelativeModality).add(abstractHarm);
            }
        }

        Map<HarmonicAnalysisDrivenChordSetAbstract, String> analyses = new HashMap<>();
        HarmonicLibrary harmonicLibrary = new HarmonicLibrary();
        for (MajorKeySignature majorKeySignature : MajorKeySignature.values()) {
            for (KeyRelativeModality modality : KeyRelativeModality.values()) {
                Key key = KeyFactory.getKey(majorKeySignature, modality);
                harmonicLibrary.register(key);

                modalityToAbstractHarms.get(modality).forEach((harmChordAbstract) -> {
                    harmonicLibrary.register(buildHarmonicAnalysisDrivenChordSet(harmChordAbstract, key, analyses));
                });
            }
        }

        return harmonicLibrary;
    }

    private static HarmonicAnalysisDrivenChordSet buildHarmonicAnalysisDrivenChordSet(
            HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract,
            Key key,
            Map<HarmonicAnalysisDrivenChordSetAbstract, String> analyses
    ) {
        if (!analyses.containsKey(harmChordAbstract)) {
            analyses.put(harmChordAbstract, HarmonicAnalysisUtil.getAnalysis(harmChordAbstract));
        }
        CanonicalNote rootNote = NoteResolver.resolveNoteFromInterval(
                key.getKeyRoot(), harmChordAbstract.getDistanceFromKeyRoot());
        Set<Chord> chords = harmChordAbstract.getAvailableChords()
                .stream()
                .map((ca) -> buildChord(ca, rootNote))
                .collect(Collectors.toSet());

        return new HarmonicAnalysisDrivenChordSet(
                harmChordAbstract,
                key,
                chords,
                harmChordAbstract.getHarmonicClassification(),
                harmChordAbstract.getHarmonicFunction(),
                analyses.get(harmChordAbstract)
        );
    }

    private static Chord buildChord(ChordAbstract chordAbstract, CanonicalNote rootNote) {
        Set<Interval> chordScale = chordAbstract.getChordScale().getIntervals();
        Set<Interval> chordQuality = chordAbstract.getChordQuality().getIntervals();
        if (!chordScale.containsAll(chordQuality) || !chordScale.containsAll(chordAbstract.getTensions())) {
            throw new IllegalStateException("ChordAbstract contains illegal interval. ChordAbstract: " + chordAbstract);
        }

        SequencedMap<Interval, CanonicalNote> intervalNoteMappings = new LinkedHashMap<>();
        Set<Interval> allIntervals = new HashSet<>();
        allIntervals.addAll(chordQuality);
        allIntervals.addAll(chordAbstract.getTensions());
        for (Interval interval : allIntervals) {
            intervalNoteMappings.put(interval, NoteResolver.resolveNoteFromInterval(rootNote, interval));
        }
        return new Chord(chordAbstract, intervalNoteMappings);
    }
}
