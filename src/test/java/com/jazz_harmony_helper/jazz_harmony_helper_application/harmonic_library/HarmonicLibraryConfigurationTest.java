package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordQuality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HarmonicLibraryConfigurationTest {
    HarmonicLibraryConfiguration harmonicLibraryConfiguration = new HarmonicLibraryConfiguration();
    ChordAbstract chord = mock();

    @Test
    public void test() {
        when(chord.getChordQuality()).thenReturn(ChordQuality.MAJOR_SEVENTH_CHORD);
        assertEquals(ChordQuality.MAJOR_SEVENTH_CHORD, chord.getChordQuality());
    }

    @Test
    void keyLibrary() {

    }

    @Test
    void createKey() {

    }

    @Test
    void buildHarmonicLibrary() {

    }

    @Test
    void buildHarmonicAnalysisDrivenChordSet() {

    }

    @Test
    void buildChord() {

    }
}