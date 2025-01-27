package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CMajorNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNoteFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.NoteModifier;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanonicalNoteResolverTest {
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

    @CsvSource(textBlock = """
            C,0,NONE
            D,2,NONE
            E,4,NONE
            F,5,NONE
            G,7,NONE
            A,9,NONE
            B,11,NONE
            C,1,SHARP
            D,3,SHARP
            E,5,SHARP
            F,6,SHARP
            G,8,SHARP
            A,10,SHARP
            B,0,SHARP
            C,2,DOUBLE_SHARP
            D,4,DOUBLE_SHARP
            E,6,DOUBLE_SHARP
            F,7,DOUBLE_SHARP
            G,9,DOUBLE_SHARP
            A,11,DOUBLE_SHARP
            B,1,DOUBLE_SHARP
            C,3,TRIPLE_SHARP
            D,5,TRIPLE_SHARP
            E,7,TRIPLE_SHARP
            F,8,TRIPLE_SHARP
            G,10,TRIPLE_SHARP
            A,0,TRIPLE_SHARP
            B,2,TRIPLE_SHARP
            C,4,QUADRUPLE_SHARP
            D,6,QUADRUPLE_SHARP
            E,8,QUADRUPLE_SHARP
            F,9,QUADRUPLE_SHARP
            G,11,QUADRUPLE_SHARP
            A,1,QUADRUPLE_SHARP
            B,3,QUADRUPLE_SHARP
            C,5,QUINTUPLE_SHARP
            D,7,QUINTUPLE_SHARP
            E,9,QUINTUPLE_SHARP
            F,10,QUINTUPLE_SHARP
            G,0,QUINTUPLE_SHARP
            A,2,QUINTUPLE_SHARP
            B,4,QUINTUPLE_SHARP
            C,6,SEXTUPLE_SHARP
            D,8,SEXTUPLE_SHARP
            E,10,SEXTUPLE_SHARP
            F,11,SEXTUPLE_SHARP
            G,1,SEXTUPLE_SHARP
            A,3,SEXTUPLE_SHARP
            B,5,SEXTUPLE_SHARP
            C,11,FLAT
            D,1,FLAT
            E,3,FLAT
            F,4,FLAT
            G,6,FLAT
            A,8,FLAT
            B,10,FLAT
            C,10,DOUBLE_FLAT
            D,0,DOUBLE_FLAT
            E,2,DOUBLE_FLAT
            F,3,DOUBLE_FLAT
            G,5,DOUBLE_FLAT
            A,7,DOUBLE_FLAT
            B,9,DOUBLE_FLAT
            C,9,TRIPLE_FLAT
            D,11,TRIPLE_FLAT
            E,1,TRIPLE_FLAT
            F,2,TRIPLE_FLAT
            G,4,TRIPLE_FLAT
            A,6,TRIPLE_FLAT
            B,8,TRIPLE_FLAT
            C,8,QUADRUPLE_FLAT
            D,10,QUADRUPLE_FLAT
            E,0,QUADRUPLE_FLAT
            F,1,QUADRUPLE_FLAT
            G,3,QUADRUPLE_FLAT
            A,5,QUADRUPLE_FLAT
            B,7,QUADRUPLE_FLAT
            C,7,QUINTUPLE_FLAT
            D,9,QUINTUPLE_FLAT
            E,11,QUINTUPLE_FLAT
            F,0,QUINTUPLE_FLAT
            G,2,QUINTUPLE_FLAT
            A,4,QUINTUPLE_FLAT
            B,6,QUINTUPLE_FLAT
    """)
    @ParameterizedTest
    public void shouldResolveNoteModifierGivenLetterNumberAndActualNumber(
            CMajorNote cMajorNote,
            int actualNumber,
            NoteModifier expectedModifier
    ) {
        int letterNumber = cMajorNote.getCanonicalNoteNumber();
        NoteModifier actualModifier = CanonicalNoteResolver.resolveNoteModifier(letterNumber, actualNumber);
        assertEquals(expectedModifier, actualModifier);
    }

    @CsvSource(textBlock = """
            F#,DIMINISHED_TONIC,F
            F#,TONIC,F#
            F#,AUGMENTED_TONIC,Fx
            F#,DIMINISHED_SECOND,Gb
            F#,MINOR_SECOND,G
            F#,MAJOR_SECOND,G#
            F#,AUGMENTED_SECOND,Gx
            F#,DIMINISHED_THIRD,Ab
            F#,MINOR_THIRD,A
            F#,MAJOR_THIRD,A#
            F#,AUGMENTED_THIRD,Ax
            F#,DIMINISHED_FOURTH,Bb
            F#,PERFECT_FOURTH,B
            F#,AUGMENTED_FOURTH,B#
            F#,DIMINISHED_FIFTH,C
            F#,PERFECT_FIFTH,C#
            F#,AUGMENTED_FIFTH,Cx
            F#,DIMINISHED_SIXTH,Db
            F#,MINOR_SIXTH,D
            F#,MAJOR_SIXTH,D#
            F#,AUGMENTED_SIXTH,Dx
            F#,DIMINISHED_SEVENTH,Eb
            F#,MINOR_SEVENTH,E
            F#,MAJOR_SEVENTH,E#
            F#,AUGMENTED_SEVENTH,Ex
    """)
    @ParameterizedTest
    public void shouldResolveAllNotesOfFSharpFromIntervals(
            String rootNote,
            Interval intervalFromRoot,
            String expectedNote
    ) {
        CanonicalNote note = CanonicalNoteResolver.resolveNoteFromAscendingInterval(notes.get(rootNote), intervalFromRoot);
        assertEquals(expectedNote, note.toString());
    }

    @CsvSource(textBlock = """
            C,DIMINISHED_TONIC,Cb
            Cb,AUGMENTED_TONIC,C
            Cb,MINOR_SECOND,Dbb
            B,AUGMENTED_TONIC,B#
            B,MINOR_SECOND,C
            B#,DIMINISHED_TONIC,B
            Cb,DIMINISHED_TONIC,Cbb
    """)
    @ParameterizedTest
    public void shouldResolveNoteFromIntervalsAroundCanonicalNoteModulus(
            String rootNote,
            Interval intervalFromRoot,
            String expectedNote
    ) {
        CanonicalNote note = CanonicalNoteResolver.resolveNoteFromAscendingInterval(notes.get(rootNote), intervalFromRoot);
        assertEquals(expectedNote, note.toString());
    }
}
