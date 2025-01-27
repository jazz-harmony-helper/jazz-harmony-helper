package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Integer> canonicalNoteNumbers() {
        return Arrays.stream(values())
                .map(CMajorNote::getCanonicalNoteNumber)
                .collect(Collectors.toList());
    }

    public static CMajorNote fromCanonicalNoteNumber(int noteNumber) {
        for (CMajorNote note : CMajorNote.values()) {
            if (note.getCanonicalNoteNumber() == noteNumber) {
                return note;
            }
        }
        throw new IllegalArgumentException("Invalid C Major note number: " + noteNumber);
    }
}
