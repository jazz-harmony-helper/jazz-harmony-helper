package com.jazz_harmony_helper.jazz_harmony_helper_application.voicing;

public class MidiNote {
    private final int midiNumber;
    private final float frequency;

    protected MidiNote(int midiNumber, float frequency) {
        this.midiNumber = midiNumber;
        this.frequency = frequency;
    }

    public int getMidiNumber() {
        return midiNumber;
    }

    public float getFrequency() {
        return frequency;
    }
}
