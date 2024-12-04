package com.jazz_harmony_helper.jazz_harmony_helper_application.configuration;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicLibraryFactory;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis.HarmonicAnalysisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HarmonicAnalysisServiceConfiguration {

    @Bean
    public HarmonicAnalysisService getHarmonicAnalysisService() {
        return new HarmonicAnalysisService(HarmonicLibraryFactory.getHarmonicLibrary());
    }
}
