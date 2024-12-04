package com.jazz_harmony_helper.jazz_harmony_helper_application.configuration;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CMajorNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNoteFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.NoteModifier;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.ScaleDegree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedMap;

public class NoteResolver {
    private static final Map<ScaleDegree, List<Interval>> SCALE_DEGREES_INTERVALS = new HashMap<>();
    private static final List<CMajorNote> ORDERED_C_MAJOR_NOTES = new ArrayList<>();

    static {
        ORDERED_C_MAJOR_NOTES.addAll(Arrays.asList(CMajorNote.values()));

        for (Interval interval : Interval.values()) {
            SCALE_DEGREES_INTERVALS.computeIfAbsent(interval.getScaleDegree(), k -> new ArrayList<>());
            SCALE_DEGREES_INTERVALS.get(interval.getScaleDegree()).add(interval);
        }
    }

    private NoteResolver() {

    }

    public static CanonicalNote resolveNoteFromInterval(CanonicalNote rootNote, Interval intervalFromRoot) {
        int noteLetterIndex = ORDERED_C_MAJOR_NOTES.indexOf(rootNote.getLetterName());
        int scaleDegreeDistanceFromRoot = intervalFromRoot.getScaleDegree().getNumber() - ScaleDegree.TONIC.getNumber();
        CMajorNote resultingLetterName = ORDERED_C_MAJOR_NOTES.get((noteLetterIndex + scaleDegreeDistanceFromRoot) % 7);
        int resultingCanonicalNoteNumber = (rootNote.getNoteCanonicalNumber() + intervalFromRoot.getCanonicalScaleDegree()) % 12;

        return resolveNoteFromLetterAndOffset(resultingLetterName, resultingCanonicalNoteNumber);
    }

    public static SequencedMap<Interval, CanonicalNote> mapAllIntervalNotes(CMajorNote noteLetterName, int canonicalNoteNumber) {
        // Match the given note name to the same note as named in C Major
        int noteNameIndex = ORDERED_C_MAJOR_NOTES.indexOf(noteLetterName);

        // For each scale degree, resolve the correct note name for all variations of the scale degree in the given key
        // and return all mappings. Scale degrees correspond to C major note names and are traversed with scale degrees
        // in order from the key root, e.g. for F major, traverses note names in the order F G A B C D E.
        SequencedMap<Interval, CanonicalNote> noteAbstractMappings = new LinkedHashMap<>();
        for (ScaleDegree scaleDegree : ScaleDegree.values()) {
            noteLetterName = ORDERED_C_MAJOR_NOTES.get(noteNameIndex++ % 7);
            for (Interval interval : SCALE_DEGREES_INTERVALS.get(scaleDegree)) {
                int noteNumber = (canonicalNoteNumber + interval.getCanonicalScaleDegree()) % 12;
                noteAbstractMappings.put(interval, resolveNoteFromLetterAndOffset(noteLetterName, noteNumber));
            }
        }

        return noteAbstractMappings;
    }

    private static CanonicalNote resolveNoteFromLetterAndOffset(CMajorNote cMajorNote, int actualNoteNumber) {
        if (actualNoteNumber == cMajorNote.getCanonicalNoteNumber()) {
            return CanonicalNoteFactory.getCanonicalNote(cMajorNote, NoteModifier.NONE);
        }

        try {
            int cMajorNoteNumber = cMajorNote.getCanonicalNoteNumber();
            int workingActualNoteNumber = actualNoteNumber;
            if (workingActualNoteNumber - cMajorNoteNumber > 6) {
                cMajorNoteNumber += 12;
            } else if (workingActualNoteNumber - cMajorNoteNumber < -6) {
                workingActualNoteNumber += 12;
            }

            int noteOffset = workingActualNoteNumber - cMajorNoteNumber;
            NoteModifier noteModifier = NoteModifier.fromOffset(noteOffset);
            return CanonicalNoteFactory.getCanonicalNote(cMajorNote, noteModifier);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Could not map note name: " + cMajorNote + " " + actualNoteNumber, e);
        }
    }
}
