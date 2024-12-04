package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

import com.jazz_harmony_helper.jazz_harmony_helper_application.configuration.NoteResolver;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoteResolverTest {
    private Map<String, CanonicalNote> notes;

    @BeforeEach
    public void setup() {
        notes = new HashMap<>();
        notes.put("F#", CanonicalNoteFactory.getCanonicalNote(CMajorNote.F, NoteModifier.SHARP));
        notes.put("C", CanonicalNoteFactory.getCanonicalNote(CMajorNote.C, NoteModifier.NONE));
        notes.put("Cb", CanonicalNoteFactory.getCanonicalNote(CMajorNote.C, NoteModifier.FLAT));
        notes.put("B", CanonicalNoteFactory.getCanonicalNote(CMajorNote.B, NoteModifier.NONE));
        notes.put("B#", CanonicalNoteFactory.getCanonicalNote(CMajorNote.B, NoteModifier.SHARP));
    }

    @CsvSource({
            "F#,DIMINISHED_TONIC,F",
            "F#,TONIC,F#",
            "F#,AUGMENTED_TONIC,Fx",
            "F#,DIMINISHED_SECOND,Gb",
            "F#,MINOR_SECOND,G",
            "F#,MAJOR_SECOND,G#",
            "F#,AUGMENTED_SECOND,Gx",
            "F#,DIMINISHED_THIRD,Ab",
            "F#,MINOR_THIRD,A",
            "F#,MAJOR_THIRD,A#",
            "F#,AUGMENTED_THIRD,Ax",
            "F#,DIMINISHED_FOURTH,Bb",
            "F#,PERFECT_FOURTH,B",
            "F#,AUGMENTED_FOURTH,B#",
            "F#,DIMINISHED_FIFTH,C",
            "F#,PERFECT_FIFTH,C#",
            "F#,AUGMENTED_FIFTH,Cx",
            "F#,DIMINISHED_SIXTH,Db",
            "F#,MINOR_SIXTH,D",
            "F#,MAJOR_SIXTH,D#",
            "F#,AUGMENTED_SIXTH,Dx",
            "F#,DIMINISHED_SEVENTH,Eb",
            "F#,MINOR_SEVENTH,E",
            "F#,MAJOR_SEVENTH,E#",
            "F#,AUGMENTED_SEVENTH,Ex"

    })
    @ParameterizedTest
    public void shouldResolveAllNotesOfFSharpFromIntervals(
            String rootNote,
            Interval intervalFromRoot,
            String expectedNote
    ) {
        CanonicalNote note = NoteResolver.resolveNoteFromInterval(notes.get(rootNote), intervalFromRoot);
        assertEquals(expectedNote, note.toString());
    }

    @CsvSource({
            "C,DIMINISHED_TONIC,Cb",
            "Cb,AUGMENTED_TONIC,C",
            "Cb,MINOR_SECOND,Dbb",
            "B,AUGMENTED_TONIC,B#",
            "B,MINOR_SECOND,C",
            "B#,DIMINISHED_TONIC,B",
            "Cb,DIMINISHED_TONIC,Cbb"
    })
    @ParameterizedTest
    public void shouldResolveNoteFromIntervalsAroundCanonicalNoteModulus(
            String rootNote,
            Interval intervalFromRoot,
            String expectedNote
    ) {
        CanonicalNote note = NoteResolver.resolveNoteFromInterval(notes.get(rootNote), intervalFromRoot);
        assertEquals(expectedNote, note.toString());
    }
}
