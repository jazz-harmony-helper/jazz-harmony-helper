package com.jazz_harmony_helper.jazz_harmony_helper_application.key;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.configuration.NoteResolver;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import java.util.HashMap;
import java.util.Map;

public class KeyFactory {
    private static final Map<CanonicalNote, Map<Interval, CanonicalNote>> KEY_CENTER_NOTE_MAPS = new HashMap<>();
    private static final Map<MajorKeySignature, Map<KeyRelativeModality, Key>> KEYS = new HashMap<>();

    private KeyFactory() {

    }

    public static Key getKey(MajorKeySignature majorKeySignature, KeyRelativeModality modality) {
        KEYS.computeIfAbsent(majorKeySignature, k -> new HashMap<>());
        if (!KEYS.get(majorKeySignature).containsKey(modality)) {
            KEYS.get(majorKeySignature).put(modality, createKey(majorKeySignature, modality));
        }

        return KEYS.get(majorKeySignature).get(modality);
    }

    private static Key createKey(MajorKeySignature majorKeySignature, KeyRelativeModality modality) {
        CanonicalNote relativeModalityRootNote = NoteResolver.resolveNoteFromInterval(
                majorKeySignature.getRootNote(),
                modality.getModalityDistanceFromRoot()
        );

        if (!KEY_CENTER_NOTE_MAPS.containsKey(relativeModalityRootNote)) {
            Map<Interval, CanonicalNote> noteMap = new HashMap<>();
            for (Interval interval : Interval.values()) {
                noteMap.put(interval, NoteResolver.resolveNoteFromInterval(relativeModalityRootNote, interval));
            }
            KEY_CENTER_NOTE_MAPS.put(relativeModalityRootNote, noteMap);
        }

        return new Key(
                majorKeySignature,
                modality,
                relativeModalityRootNote,
                NoteResolver.mapAllIntervalNotes(
                        relativeModalityRootNote.getLetterName(),
                        relativeModalityRootNote.getNoteCanonicalNumber()
                )
        );
    }
}
