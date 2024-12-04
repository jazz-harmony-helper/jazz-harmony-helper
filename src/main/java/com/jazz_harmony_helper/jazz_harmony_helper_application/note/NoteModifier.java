package com.jazz_harmony_helper.jazz_harmony_helper_application.note;

public enum NoteModifier {
    NONE("", 0),
    SHARP("#", 1),
    FLAT("b", -1),
    DOUBLE_SHARP("x", 2),
    DOUBLE_FLAT("bb", -2),
    TRIPLE_SHARP("#x", 3),
    TRIPLE_FLAT("bbb", -3),
    QUADRUPLE_SHARP("xx", 4),
    QUADRUPLE_FLAT("bbbb", -4);

    private final String representation;
    private final int offset;

    NoteModifier(String representation, int offset) {
        this.representation = representation;
        this.offset = offset;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public int getOffset() {
        return this.offset;
    }

    public static NoteModifier fromOffset(int offset) {
        for (NoteModifier noteModifier : NoteModifier.values()) {
            if (noteModifier.getOffset() == offset) {
                return noteModifier;
            }
        }
        throw new IllegalArgumentException("Invalid note modifier offset: " + offset);
    }
}
