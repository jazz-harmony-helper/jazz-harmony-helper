package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarmonicLibraryFactoryTest {

    @Test
    public void shouldReturnSameInstance() {
        HarmonicLibrary harmonicLibrary1 = HarmonicLibraryFactory.getHarmonicLibrary();
        HarmonicLibrary harmonicLibrary2 = HarmonicLibraryFactory.getHarmonicLibrary();
        assertEquals(harmonicLibrary1, harmonicLibrary2);
    }

    @Test
    public void shouldBuildHarmonicLibrary() {
        HarmonicLibrary harmonicLibrary = HarmonicLibraryFactory.getHarmonicLibrary();

        assertNotNull(harmonicLibrary);
    }

}