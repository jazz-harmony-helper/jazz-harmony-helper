package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

public enum CMajorNote {
    A(9),
    B(11),
    C(0),
    D(2),
    E(4),
    F(5),
    G(7);

    private final int canonicalNoteNumber;

    CMajorNote(int canonicalNoteNumber) {
        this.canonicalNoteNumber = canonicalNoteNumber;
    }

    public int getCanonicalNoteNumber() {
        return canonicalNoteNumber;
    }
}
