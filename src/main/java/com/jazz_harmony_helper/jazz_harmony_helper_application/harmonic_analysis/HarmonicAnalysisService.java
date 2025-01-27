package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_library.KeyLibrary;
import org.springframework.stereotype.Service;

@Service
public class HarmonicAnalysisService {
    private final KeyLibrary keyLibrary;

    public HarmonicAnalysisService(KeyLibrary keyLibrary) {
        this.keyLibrary = keyLibrary;
    }

}
