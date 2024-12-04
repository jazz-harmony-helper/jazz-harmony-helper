package com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSet;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicFunction;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicMotionType;
import org.springframework.stereotype.Component;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicMotionType.*;

@Component
public class HarmonicMotionResolver {
    public HarmonicMotionType resolveHarmonicMotion(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        HarmonicFunction previousChordFunction = previousChord.getHarmonicFunction();
        HarmonicFunction nextChordFunction = nextChord.getHarmonicFunction();

        switch (previousChordFunction) {
            case TONIC:
                return resolveFromTonic(previousChord, nextChord);
            case SUBDOMINANT:
                return resolveFromSubdominant(previousChord, nextChord);
            case DOMINANT:
                return resolveFromDominant(previousChord, nextChord);
            case SECONDARY_DOMINANT:
                return resolveFromSecondaryDominant(previousChord, nextChord);
            case ASCENDING_DIMINISHED:
                return resolveFromAscendingDiminished(previousChord, nextChord);
            case PASSING_DIMINISHED:
                return resolveFromPassingDiminished(previousChord, nextChord);
            case AUXILIARY_DIMINISHED:
                return resolveFromAuxiliaryDiminished(previousChord, nextChord);
            case CONSTANT_STRUCTURE:
                return resolveFromConstantStructure(nextChordFunction);
            case DIMINISHED_APPROACH:
            default:
                return UNDEFINED;
        }
    }

    private HarmonicMotionType resolveFromTonic(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
//        switch (nextChordFunction) {
//            case TONIC:
//                return PROLONGATION;
//            case SUBDOMINANT:
//            case DOMINANT:
//            case SECONDARY_DOMINANT:
//            case ASCENDING_DIMINISHED:
//            case PASSING_DIMINISHED:
//            case AUXILIARY_DIMINISHED:
//                return PROGRESSION;
//            case CONSTANT_STRUCTURE:
//            case DIMINISHED_APPROACH:
//                return KEY_DEPARTURE;
//            default:
//                return UNDEFINED;
//        }
        return null;
    }

    private HarmonicMotionType resolveFromSubdominant(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromDominant (HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromSecondaryDominant(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromAscendingDiminished(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromPassingDiminished(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromAuxiliaryDiminished(HarmonicAnalysisDrivenChordSet previousChord, HarmonicAnalysisDrivenChordSet nextChord) {
        return null;
    }

    private HarmonicMotionType resolveFromConstantStructure(HarmonicFunction nextChordFunction) {
        if (nextChordFunction == HarmonicFunction.CONSTANT_STRUCTURE) {
            return HarmonicMotionType.CONSTANT_STRUCTURE;
        }
        return UNDEFINED;
    }
}
