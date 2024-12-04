package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSetAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HarmonicAnalysisUtilTest {

    @CsvSource({
            "TONIC,PERFECT_FOURTH",
            "MAJOR_SECOND,PERFECT_FIFTH",
            "MINOR_THIRD,MINOR_SIXTH",
            "PERFECT_FIFTH,TONIC",
            "MINOR_SIXTH,MINOR_SECOND",
            "MAJOR_SIXTH,MAJOR_SECOND",
            "MINOR_SEVENTH,MINOR_THIRD"
    })
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_Dominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveIntervalUpInKeyContext(rootInterval, Interval.PERFECT_FOURTH);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "AUGMENTED_TONIC,MAJOR_SECOND",
            "AUGMENTED_SECOND,MAJOR_THIRD",
            "AUGMENTED_FIFTH,MAJOR_SIXTH"
    })
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_AscendingDiminished(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveIntervalUpInKeyContext(rootInterval, Interval.MINOR_SECOND);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "TONIC,PERFECT_FOURTH",
            "MAJOR_SECOND,PERFECT_FIFTH",
            "MINOR_THIRD,MINOR_SIXTH",
            "PERFECT_FIFTH,TONIC",
            "MINOR_SIXTH,MINOR_SECOND",
            "MAJOR_SIXTH,MAJOR_SECOND",
            "MINOR_SEVENTH,MINOR_THIRD"
    })
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_Dominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveIntervalDownInKeyContext(rootInterval, Interval.PERFECT_FIFTH);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "MINOR_SECOND,TONIC",
            "MINOR_THIRD,MAJOR_SECOND",
            "DIMINISHED_FOURTH,MINOR_THIRD",
            "PERFECT_FOURTH,MAJOR_THIRD",
            "DIMINISHED_FIFTH,PERFECT_FOURTH",
            "MINOR_SIXTH,PERFECT_FIFTH",
            "DIMINISHED_SEVENTH,MINOR_SIXTH",
            "MINOR_SEVENTH,MAJOR_SIXTH"
    })
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_SubstituteDominant(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveIntervalDownInKeyContext(rootInterval, Interval.MINOR_SECOND);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "MAJOR_TONIC_MAJOR_SEVENTH,IMaj7",
            "MAJOR_TONIC_MAJOR_SIXTH,I6",
            "MAJOR_TWO_MINOR_SEVEN,ii-7",
            "MAJOR_THREE_MINOR_SEVEN,iii-7",
            "MAJOR_FOUR_MAJOR_SEVEN,IVMaj7",
            "MAJOR_FOUR_MAJOR_SIXTH,IV6",
            "MAJOR_FIVE_DOMINANT_SEVENTH,V7",
            "MAJOR_FIVE_MAJOR_SIXTH,V6",
            "MAJOR_SIX_MINOR_SEVENTH,vi-7"
    })
    @ParameterizedTest
    public void shouldAnalyzeDiatonicChords(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "MAJOR_FIVE_OF_FOUR,V/IV",
            "MAJOR_FIVE_OF_FIVE,V/V",
            "MAJOR_FIVE_OF_SIX,V/VI",
            "MAJOR_FIVE_OF_THREE,V/III",
            "MAJOR_FIVE_OF_TWO,V/II"
    })
    @ParameterizedTest
    public void shouldAnalyzeSecondaryDominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "MAJOR_SUB_FIVE,SubV/I",
            "MAJOR_SUB_FIVE_OF_TWO,SubV/II",
            "MAJOR_SUB_FIVE_OF_THREE,SubV/III",
            "MAJOR_SUB_FIVE_OF_FOUR,SubV/IV",
            "MAJOR_SUB_FIVE_OF_FIVE,SubV/V",
            "MAJOR_SUB_FIVE_OF_SIX,SubV/VI"
    })
    @ParameterizedTest
    public void shouldAnalyzeSubstituteDominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
        assertEquals(expected, actual);
    }

    @CsvSource({
            "MAJOR_TWO_OF_FOUR,ii/IV",
            "MAJOR_TWO_OF_SIX,ii/VI",
            "MAJOR_TWO_OF_TWO,ii/II",
            "MAJOR_TWO_OF_THREE,ii/III",
            "MAJOR_TWO_OF_FIVE,ii/V"
    })
    @ParameterizedTest
    public void shouldAnalyzeSecondaryPredominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
        assertEquals(expected, actual);
    }

}