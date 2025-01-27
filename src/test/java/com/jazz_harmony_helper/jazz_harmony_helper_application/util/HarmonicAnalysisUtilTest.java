package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSetAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HarmonicAnalysisUtilTest {

    @CsvSource(textBlock = """
            TONIC,PERFECT_FOURTH
            MAJOR_SECOND,PERFECT_FIFTH
            MINOR_THIRD,MINOR_SIXTH
            MAJOR_THIRD,MAJOR_SIXTH
            PERFECT_FIFTH,TONIC
            MINOR_SIXTH,MINOR_SECOND
            MAJOR_SIXTH,MAJOR_SECOND
            MINOR_SEVENTH,MINOR_THIRD
            MAJOR_SEVENTH,MAJOR_THIRD
    """)
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_Dominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationUpIntervalDistance(rootInterval, Interval.PERFECT_FOURTH);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            AUGMENTED_TONIC,MAJOR_SECOND
            AUGMENTED_SECOND,MAJOR_THIRD
            AUGMENTED_FIFTH,MAJOR_SIXTH
            MAJOR_SEVENTH,TONIC
    """)
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_AscendingDiminished(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationUpIntervalDistance(rootInterval, Interval.MINOR_SECOND);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            DIMINISHED_TONIC,DIMINISHED_TONIC
            TONIC,TONIC
            AUGMENTED_TONIC,AUGMENTED_TONIC
            DIMINISHED_SECOND,DIMINISHED_SECOND
            MINOR_SECOND,MINOR_SECOND
            MAJOR_SECOND,MAJOR_SECOND
            AUGMENTED_SECOND,AUGMENTED_SECOND
            DIMINISHED_THIRD,DIMINISHED_THIRD
            MINOR_THIRD,MINOR_THIRD
            MAJOR_THIRD,MAJOR_THIRD
            AUGMENTED_THIRD,AUGMENTED_THIRD
            DIMINISHED_FOURTH,DIMINISHED_FOURTH
            PERFECT_FOURTH,PERFECT_FOURTH
            AUGMENTED_FOURTH,AUGMENTED_FOURTH
            DIMINISHED_FIFTH,DIMINISHED_FIFTH
            PERFECT_FIFTH,PERFECT_FIFTH
            AUGMENTED_FIFTH,AUGMENTED_FIFTH
            DIMINISHED_SIXTH,DIMINISHED_SIXTH
            MINOR_SIXTH,MINOR_SIXTH
            MAJOR_SIXTH,MAJOR_SIXTH
            AUGMENTED_SIXTH,AUGMENTED_SIXTH
            DIMINISHED_SEVENTH,DIMINISHED_SEVENTH
            MINOR_SEVENTH,MINOR_SEVENTH
            MAJOR_SEVENTH,MAJOR_SEVENTH
            AUGMENTED_SEVENTH,AUGMENTED_SEVENTH
    """)
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_AllIntervalsFromTonic(Interval intervalAscended, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationUpIntervalDistance(Interval.TONIC, intervalAscended);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            TONIC,PERFECT_FIFTH
            MINOR_SECOND,MINOR_SIXTH
            MAJOR_SECOND,MAJOR_SIXTH
            MINOR_THIRD,MINOR_SEVENTH
            MAJOR_THIRD,MAJOR_SEVENTH
            PERFECT_FOURTH,TONIC
            AUGMENTED_FOURTH,AUGMENTED_TONIC
            DIMINISHED_FIFTH,MINOR_SECOND
            PERFECT_FIFTH,MAJOR_SECOND
            AUGMENTED_FIFTH,AUGMENTED_SECOND
            MINOR_SIXTH,MINOR_THIRD
            MAJOR_SIXTH,MAJOR_THIRD
            MINOR_SEVENTH,PERFECT_FOURTH
            MAJOR_SEVENTH,AUGMENTED_FOURTH
    """)
    @ParameterizedTest
    public void shouldResolveIntervalUpInKeyContext_FromPerfectFifth(Interval intervalAscended, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationUpIntervalDistance(Interval.PERFECT_FIFTH, intervalAscended);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            TONIC,PERFECT_FOURTH
            MAJOR_SECOND,PERFECT_FIFTH
            MINOR_THIRD,MINOR_SIXTH
            PERFECT_FIFTH,TONIC
            MINOR_SIXTH,MINOR_SECOND
            MAJOR_SIXTH,MAJOR_SECOND
            MINOR_SEVENTH,MINOR_THIRD
    """)
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_Dominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationDownIntervalDistance(rootInterval, Interval.PERFECT_FIFTH);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            MINOR_SECOND,TONIC
            MINOR_THIRD,MAJOR_SECOND
            DIMINISHED_FOURTH,MINOR_THIRD
            PERFECT_FOURTH,MAJOR_THIRD
            DIMINISHED_FIFTH,PERFECT_FOURTH
            MINOR_SIXTH,PERFECT_FIFTH
            DIMINISHED_SEVENTH,MINOR_SIXTH
            MINOR_SEVENTH,MAJOR_SIXTH
    """)
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_SubstituteDominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationDownIntervalDistance(rootInterval, Interval.MINOR_SECOND);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            MAJOR_THIRD,MAJOR_SECOND
            PERFECT_FOURTH,MINOR_THIRD
            AUGMENTED_FOURTH,MAJOR_THIRD
            PERFECT_FIFTH,PERFECT_FOURTH
            MAJOR_SIXTH,PERFECT_FIFTH
            MINOR_SEVENTH,MINOR_SIXTH
            MAJOR_SEVENTH,MAJOR_SIXTH
    """)
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_SecondaryPreDominants(Interval rootInterval, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationDownIntervalDistance(rootInterval, Interval.MAJOR_SECOND);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            DIMINISHED_TONIC,AUGMENTED_TONIC
            TONIC,TONIC
            AUGMENTED_TONIC,DIMINISHED_TONIC
            DIMINISHED_SECOND,AUGMENTED_SEVENTH
            MINOR_SECOND,MAJOR_SEVENTH
            MAJOR_SECOND,MINOR_SEVENTH
            AUGMENTED_SECOND,DIMINISHED_SEVENTH
            DIMINISHED_THIRD,AUGMENTED_SIXTH
            MINOR_THIRD,MAJOR_SIXTH
            MAJOR_THIRD,MINOR_SIXTH
            AUGMENTED_THIRD,DIMINISHED_SIXTH
            DIMINISHED_FOURTH,AUGMENTED_FIFTH
            PERFECT_FOURTH,PERFECT_FIFTH
            AUGMENTED_FOURTH,DIMINISHED_FIFTH
            DIMINISHED_FIFTH,AUGMENTED_FOURTH
            PERFECT_FIFTH,PERFECT_FOURTH
            AUGMENTED_FIFTH,DIMINISHED_FOURTH
            DIMINISHED_SIXTH,AUGMENTED_THIRD
            MINOR_SIXTH,MAJOR_THIRD
            MAJOR_SIXTH,MINOR_THIRD
            AUGMENTED_SIXTH,DIMINISHED_THIRD
            DIMINISHED_SEVENTH,AUGMENTED_SECOND
            MINOR_SEVENTH,MAJOR_SECOND
            MAJOR_SEVENTH,MINOR_SECOND
            AUGMENTED_SEVENTH,DIMINISHED_SECOND
    """)
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_AllIntervalsFromTonic(Interval intervalDescended, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationDownIntervalDistance(Interval.TONIC, intervalDescended);
        assertEquals(expected, actual);
    }

    @CsvSource(textBlock = """
            TONIC,PERFECT_FIFTH
            MINOR_SECOND,AUGMENTED_FOURTH
            MAJOR_SECOND,PERFECT_FOURTH
            MINOR_THIRD,MAJOR_THIRD
            MAJOR_THIRD,MINOR_THIRD
            PERFECT_FOURTH,MAJOR_SECOND
            AUGMENTED_FOURTH,MINOR_SECOND
            DIMINISHED_FIFTH,AUGMENTED_TONIC
            PERFECT_FIFTH,TONIC
            AUGMENTED_FIFTH,DIMINISHED_TONIC
            MINOR_SIXTH,MAJOR_SEVENTH
            MAJOR_SIXTH,MINOR_SEVENTH
            MINOR_SEVENTH,MAJOR_SIXTH
            MAJOR_SEVENTH,MINOR_SIXTH
    """)
    @ParameterizedTest
    public void shouldResolveIntervalDownInKeyContext_FromPerfectFifth(Interval intervalDescended, Interval expected) {
        Interval actual = HarmonicAnalysisUtil.resolveKeyLocationDownIntervalDistance(Interval.PERFECT_FIFTH, intervalDescended);
        assertEquals(expected, actual);
    }

//    @CsvSource({
//            "MAJOR_TONIC_MAJOR_SEVENTH,IMaj7",
//            "MAJOR_TONIC_MAJOR_SIXTH,I6",
//            "MAJOR_TWO_MINOR_SEVEN,ii-7",
//            "MAJOR_THREE_MINOR_SEVEN,iii-7",
//            "MAJOR_FOUR_MAJOR_SEVEN,IVMaj7",
//            "MAJOR_FOUR_MAJOR_SIXTH,IV6",
//            "MAJOR_FIVE_DOMINANT_SEVENTH,V7",
//            "MAJOR_FIVE_MAJOR_SIXTH,V6",
//            "MAJOR_SIX_MINOR_SEVENTH,vi-7"
//    })
//    @ParameterizedTest
//    public void shouldAnalyzeDiatonicChords(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
//        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
//        assertEquals(expected, actual);
//    }
//
//    @CsvSource({
//            "MAJOR_FIVE_OF_FOUR,V/IV",
//            "MAJOR_FIVE_OF_FIVE,V/V",
//            "MAJOR_FIVE_OF_SIX,V/VI",
//            "MAJOR_FIVE_OF_THREE,V/III",
//            "MAJOR_FIVE_OF_TWO,V/II"
//    })
//    @ParameterizedTest
//    public void shouldAnalyzeSecondaryDominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
//        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
//        assertEquals(expected, actual);
//    }
//
//    @CsvSource({
//            "MAJOR_SUB_FIVE,SubV/I",
//            "MAJOR_SUB_FIVE_OF_TWO,SubV/II",
//            "MAJOR_SUB_FIVE_OF_THREE,SubV/III",
//            "MAJOR_SUB_FIVE_OF_FOUR,SubV/IV",
//            "MAJOR_SUB_FIVE_OF_FIVE,SubV/V",
//            "MAJOR_SUB_FIVE_OF_SIX,SubV/VI"
//    })
//    @ParameterizedTest
//    public void shouldAnalyzeSubstituteDominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
//        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
//        assertEquals(expected, actual);
//    }
//
//    @CsvSource({
//            "MAJOR_TWO_OF_FOUR,ii/IV",
//            "MAJOR_TWO_OF_SIX,ii/VI",
//            "MAJOR_TWO_OF_TWO,ii/II",
//            "MAJOR_TWO_OF_THREE,ii/III",
//            "MAJOR_TWO_OF_FIVE,ii/V"
//    })
//    @ParameterizedTest
//    public void shouldAnalyzeSecondaryPredominants(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract, String expected) {
//        String actual = HarmonicAnalysisUtil.getAnalysis(harmChordAbstract);
//        assertEquals(expected, actual);
//    }

}