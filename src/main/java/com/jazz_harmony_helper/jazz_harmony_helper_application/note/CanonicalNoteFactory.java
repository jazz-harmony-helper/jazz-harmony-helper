package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

import java.util.HashMap;
import java.util.Map;

public class CanonicalNoteFactory {
    private static final Map<String, CanonicalNote> NOTES = new HashMap<>();

    public static CanonicalNote getCanonicalNote(
            CMajorNote cMajorNote,
            NoteModifier modifier
    ) {
        String identifier = cMajorNote.toString() + modifier.getRepresentation();
        if (!NOTES.containsKey(identifier)) {
            NOTES.put(identifier, new CanonicalNote(
                    cMajorNote, modifier, canonicalNoteNumber(cMajorNote, modifier)));
        }
        return NOTES.get(identifier);
    }

    private static int canonicalNoteNumber(CMajorNote cMajorNote, NoteModifier modifier) {
        return (cMajorNote.getCanonicalNoteNumber() + modifier.getOffset() + 12) % 12;
    }
}
