package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CMajorNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNoteFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.NoteModifier;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.ScaleDegree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanonicalNoteResolver {
    private static final Map<ScaleDegree, List<Interval>> SCALE_DEGREES_INTERVALS = new HashMap<>();
    private static final List<CMajorNote> ORDERED_C_MAJOR_NOTES = new ArrayList<>();

    static {
        ORDERED_C_MAJOR_NOTES.addAll(Arrays.asList(CMajorNote.values()));

        for (Interval interval : Interval.values()) {
            SCALE_DEGREES_INTERVALS.computeIfAbsent(interval.getScaleDegree(), k -> new ArrayList<>());
            SCALE_DEGREES_INTERVALS.get(interval.getScaleDegree()).add(interval);
        }
    }

    private CanonicalNoteResolver() {

    }

    public static CanonicalNote resolveNoteFromAscendingInterval(CanonicalNote rootNote, Interval intervalFromRoot) {
        // Modulo works well with zero-indexed array indices, but not with scale degrees, which are numbered 1-7.
        // Use an array of C Major notes to calculate the new scale degree.
        int noteLetterIndex = ORDERED_C_MAJOR_NOTES.indexOf(rootNote.getLetterName());
        // If moving up a Perfect Fifth from the Tonic, need to move from scale degree 1 to 5 -- up 4 steps
        int scaleDegreesToAdvance = intervalFromRoot.getScaleDegree().getNumber() - 1;
        CMajorNote cMajorNote = ORDERED_C_MAJOR_NOTES.get((noteLetterIndex + scaleDegreesToAdvance) % 7);

        // Resolve the appropriate modifier by comparing the Letter name's canonical note number with new note number
        int newCanonicalNoteNumber = (rootNote.getNoteCanonicalNumber() + intervalFromRoot.getSemitoneSteps()) % 12;
        NoteModifier noteModifier = resolveNoteModifier(cMajorNote.getCanonicalNoteNumber(), newCanonicalNoteNumber);

        return CanonicalNoteFactory.getCanonicalNote(cMajorNote, noteModifier);
    }

    public static NoteModifier resolveNoteModifier(int letterCanonicalNoteNumber, int actualCanonicalNoteNumber) {
        if (!CMajorNote.canonicalNoteNumbers().contains(letterCanonicalNoteNumber)) {
            throw new IllegalArgumentException("There is no letter name which corresponds to canonical note number: " + letterCanonicalNoteNumber);
        }

        int noteOffset = 0;
        if (letterCanonicalNoteNumber > actualCanonicalNoteNumber) {
            if (letterCanonicalNoteNumber - actualCanonicalNoteNumber >= 6) {
                noteOffset = (actualCanonicalNoteNumber + 12) - letterCanonicalNoteNumber;
            } else {
                noteOffset = actualCanonicalNoteNumber - letterCanonicalNoteNumber;
            }
        } else if (letterCanonicalNoteNumber < actualCanonicalNoteNumber) {
            if (actualCanonicalNoteNumber - letterCanonicalNoteNumber > 6) {
                noteOffset = actualCanonicalNoteNumber - (letterCanonicalNoteNumber + 12);
            } else {
                noteOffset = actualCanonicalNoteNumber - letterCanonicalNoteNumber;
            }
        }

        return NoteModifier.fromOffset(noteOffset);
    }

}
