package com.jazz_harmony_helper.jazz_harmony_helper_application.key;

import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CMajorNote;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.CanonicalNoteFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.note.NoteModifier;

public enum MajorKeySignature {
    C(
            CMajorNote.C,
            NoteModifier.NONE,
            true
    ),

    /*
     * Sharp keys
     */
    G(
            CMajorNote.G,
            NoteModifier.NONE,
            true
    ),
    D(
            CMajorNote.D,
            NoteModifier.NONE,
            true
    ),
    A(
            CMajorNote.A,
            NoteModifier.NONE,
            true
    ),
    E(
            CMajorNote.E,
            NoteModifier.NONE,
            true
    ),
    B(
            CMajorNote.B,
            NoteModifier.NONE,
            true
    ),
    F_SHARP(
            CMajorNote.F,
            NoteModifier.SHARP,
            true
    ),
    C_SHARP(
            CMajorNote.C,
            NoteModifier.SHARP,
            true
    ),

    /*
     * Flat keys
     */
    F(
            CMajorNote.F,
            NoteModifier.NONE,
            true
    ),
    B_FLAT(
            CMajorNote.B,
            NoteModifier.FLAT,
            true
    ),
    E_FLAT(
            CMajorNote.E,
            NoteModifier.FLAT,
            true
    ),
    A_FLAT(
            CMajorNote.A,
            NoteModifier.FLAT,
            true
    ),
    D_FLAT(
            CMajorNote.D,
            NoteModifier.FLAT,
            true
    ),
    G_FLAT(
            CMajorNote.G,
            NoteModifier.FLAT,
            true
    ),
    C_FLAT(
            CMajorNote.C,
            NoteModifier.FLAT,
            true
    ),

    /*
     * Modulation only sharp keys
     */
    G_SHARP(
            CMajorNote.G,
            NoteModifier.SHARP,
            false
    ),
    D_SHARP(
            CMajorNote.D,
            NoteModifier.SHARP,
            false
    ),
    A_SHARP(
            CMajorNote.A,
            NoteModifier.SHARP,
            false
    ),
    E_SHARP(
            CMajorNote.E,
            NoteModifier.SHARP,
            false
    ),
    B_SHARP(
            CMajorNote.B,
            NoteModifier.SHARP,
            false
    ),
    F_DOUBLE_SHARP(
            CMajorNote.F,
            NoteModifier.DOUBLE_SHARP,
            false
    ),
    C_DOUBLE_SHARP(
            CMajorNote.C,
            NoteModifier.DOUBLE_SHARP,
            false
    ),

    /*
     * Modulation only flat keys
     */
    F_FLAT(
            CMajorNote.F,
            NoteModifier.FLAT,
            false
    ),
    B_DOUBLE_FLAT(
            CMajorNote.B,
            NoteModifier.DOUBLE_FLAT,
            false
    ),
    E_DOUBLE_FLAT(
            CMajorNote.E,
            NoteModifier.DOUBLE_FLAT,
            false
    ),
    A_DOUBLE_FLAT(
            CMajorNote.A,
            NoteModifier.DOUBLE_FLAT,
            false
    ),
    D_DOUBLE_FLAT(
            CMajorNote.D,
            NoteModifier.DOUBLE_FLAT,
            false
    ),
    G_DOUBLE_FLAT(
            CMajorNote.G,
            NoteModifier.DOUBLE_FLAT,
            false
    ),
    C_DOUBLE_FLAT(
            CMajorNote.C,
            NoteModifier.DOUBLE_FLAT,
            false
    );

    private final CMajorNote rootLetterName;
    private final NoteModifier rootNoteModifier;
    private final boolean isSelectable;

    MajorKeySignature(
            CMajorNote rootLetterName,
            NoteModifier rootNoteModifier,
            boolean isSelectable
    ) {
        this.rootLetterName = rootLetterName;
        this.rootNoteModifier = rootNoteModifier;
        this.isSelectable = isSelectable;
    }

    public CanonicalNote getRootNote() {
        return CanonicalNoteFactory.getCanonicalNote(rootLetterName, rootNoteModifier);
    }

    public boolean isSelectable() {
        return isSelectable;
    }
}
