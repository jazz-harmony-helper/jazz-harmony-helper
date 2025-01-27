package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.Chord;
import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSet;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSetAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.Key;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.KeyRelativeModality;
import com.jazz_harmony_helper.jazz_harmony_helper_application.key.MajorKeySignature;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.util.CanonicalNoteResolver;
import com.jazz_harmony_helper.jazz_harmony_helper_application.util.HarmonicAnalysisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class HarmonicLibraryConfiguration {

    @Bean
    public KeyLibrary keyLibrary() {
        // Group HarmonicAnalysisDrivenChordAbstracts by available modality
        Map<KeyRelativeModality, SequencedSet<HarmonicAnalysisDrivenChordSetAbstract>> modalityToAbstractHarms = new HashMap<>();
        for (HarmonicAnalysisDrivenChordSetAbstract abstractHarm : HarmonicAnalysisDrivenChordSetAbstract.values()) {
            for (KeyRelativeModality keyRelativeModality : abstractHarm.getModalityAvailability()) {
                modalityToAbstractHarms.computeIfAbsent(keyRelativeModality, k -> new LinkedHashSet<>());
                modalityToAbstractHarms.get(keyRelativeModality).add(abstractHarm);
            }
        }

        // Build every key, along with all harmonic analysis driven chord sets and real chords, and store in a
        // Key Library
        Set<Key> keys = new HashSet<>();
        for (MajorKeySignature keySignature : MajorKeySignature.values()) {
            for (KeyRelativeModality modality : KeyRelativeModality.values()) {
                keys.add(createKey(keySignature, modality, modalityToAbstractHarms));
            }
        }
        return new KeyLibrary(keys);
    }

    protected Key createKey(
            MajorKeySignature majorKeySignature,
            KeyRelativeModality modality,
            Map<KeyRelativeModality, SequencedSet<HarmonicAnalysisDrivenChordSetAbstract>> modalityToAbstractHarms
    ) {
        // Find the root note for the given key (key = Major key signature + modality)
        CanonicalNote relativeModalityRootNote = CanonicalNoteResolver.resolveNoteFromAscendingInterval(
                majorKeySignature.getRootNote(),
                modality.getModalityDistanceFromRoot()
        );

        // Map every interval from the root of the given modality and store on the Key object
        SequencedMap<Interval, CanonicalNote> noteMap = new LinkedHashMap<>();
        for (Interval interval : Interval.values()) {
            noteMap.put(interval, CanonicalNoteResolver.resolveNoteFromAscendingInterval(relativeModalityRootNote, interval));
        }

        Key key = new Key(majorKeySignature, modality, relativeModalityRootNote, noteMap);

        // Build Harmonic Library for given key
        key.setHarmonicLibrary(buildHarmonicLibrary(key, modalityToAbstractHarms.get(key.getModality())));

        return key;
    }

    protected HarmonicLibrary buildHarmonicLibrary(
            Key key,
            SequencedSet<HarmonicAnalysisDrivenChordSetAbstract> harmChordsAbstract
    ) {
        SequencedSet<HarmonicAnalysisDrivenChordSet> harmChords = new LinkedHashSet<>();

        harmChordsAbstract.forEach((harmChordAbstract) -> {
            harmChords.add(buildHarmonicAnalysisDrivenChordSet(harmChordAbstract, key));
        });

        return new HarmonicLibrary(harmChords);
    }

    protected HarmonicAnalysisDrivenChordSet buildHarmonicAnalysisDrivenChordSet(
            HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract,
            Key key
    ) {
        CanonicalNote rootNote = CanonicalNoteResolver.resolveNoteFromAscendingInterval(
                key.getKeyRoot(),
                harmChordAbstract.getDistanceFromKeyRoot()
        );
        Set<Chord> chords = harmChordAbstract.getChordAbstracts()
                .stream()
                .map((ca) -> buildChord(harmChordAbstract, ca, rootNote))
                .collect(Collectors.toSet());

        return new HarmonicAnalysisDrivenChordSet(harmChordAbstract, chords);
    }

    protected Chord buildChord(
            HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract,
            ChordAbstract chordAbstract,
            CanonicalNote rootNote
    ) {
        Set<Interval> chordScaleIntervals = chordAbstract.getChordScale().getIntervals();
        Set<Interval> chordIntervals = chordAbstract.getChordQuality().getIntervals();
        if (!chordScaleIntervals.containsAll(chordIntervals) || !chordScaleIntervals.containsAll(chordAbstract.getTensions())) {
            throw new IllegalStateException("ChordAbstract contains illegal interval. ChordAbstract: " + chordAbstract);
        }

        SequencedMap<Interval, CanonicalNote> intervalNoteMappings = new LinkedHashMap<>();
        for (Interval interval : chordAbstract.getChordScale().getIntervals()) {
            intervalNoteMappings.put(interval, CanonicalNoteResolver.resolveNoteFromAscendingInterval(rootNote, interval));
        }

        SequencedMap<Interval, CanonicalNote> chordNoteMappings = new LinkedHashMap<>();
        for (Interval interval : chordIntervals) {
            chordNoteMappings.put(interval, intervalNoteMappings.get(interval));
        }
        SequencedMap<Interval, CanonicalNote> tensionNoteMappings = new LinkedHashMap<>();
        for (Interval interval : chordAbstract.getTensions()) {
            tensionNoteMappings.put(interval, intervalNoteMappings.get(interval));
        }

        String chordAnalysis = HarmonicAnalysisUtil.getChordAnalysis(harmChordAbstract, chordAbstract);

        return new Chord(chordAbstract, chordAnalysis, chordNoteMappings, tensionNoteMappings, intervalNoteMappings);
    }

}
