package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

public class CanonicalNote {
    private final CMajorNote letterName;
    private final NoteModifier modifier;
    private final int noteCanonicalNumber;

    protected CanonicalNote(CMajorNote letterName, NoteModifier modifier, int noteCanonicalNumber) {
        this.letterName = letterName;
        this.modifier = modifier;
        this.noteCanonicalNumber = noteCanonicalNumber;
    }

    public CMajorNote getLetterName() {
        return letterName;
    }

    public NoteModifier getModifier() {
        return modifier;
    }

    public int getNoteCanonicalNumber() {
        return noteCanonicalNumber;
    }

    @Override
    public String toString() {
        return this.letterName.toString() + modifier.getRepresentation();
    }
}
