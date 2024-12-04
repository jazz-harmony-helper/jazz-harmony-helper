package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSetAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicClassification;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.ScaleDegree;

import java.util.Arrays;
import java.util.List;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicClassification.*;

public class HarmonicAnalysisUtil {

    private HarmonicAnalysisUtil() {

    }

    public static String getAnalysis(HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract) {
        HarmonicClassification classification = harmChordAbstract.getHarmonicClassification();

        if (classification == SECONDARY_DOMINANT) {
            Interval target = resolveIntervalUpInKeyContext(harmChordAbstract.getDistanceFromKeyRoot(), Interval.PERFECT_FOURTH);
            return "V/" + getRomanNumeral(target);
        } else if (classification == SUBSTITUTE_DOMINANT) {
            Interval target = resolveIntervalDownInKeyContext(harmChordAbstract.getDistanceFromKeyRoot(), Interval.MINOR_SECOND);
            return "SubV/" + getRomanNumeral(target);
        } else if (classification == SECONDARY_PREDOMINANT) {
            Interval target = resolveIntervalDownInKeyContext(harmChordAbstract.getDistanceFromKeyRoot(), Interval.MAJOR_SECOND);
            return "ii/" + getRomanNumeral(target);
        }

        Interval distanceFromRoot = harmChordAbstract.getDistanceFromKeyRoot();
        String analysis = getRomanNumeral(distanceFromRoot);

        if (harmChordAbstract.getAnalyzedQuality().getIntervals().contains(Interval.MINOR_THIRD)) {
            analysis = analysis
                    .replaceAll("V", "v")
                    .replaceAll("I", "i");
        }

        return analysis + harmChordAbstract.getAnalyzedQuality().getRepresentation();
    }

    private static String getRomanNumeral(Interval distanceFromRoot) {
        String prefix = switch (distanceFromRoot) {
            case DIMINISHED_TONIC, MINOR_SECOND, MINOR_THIRD, DIMINISHED_FOURTH, DIMINISHED_FIFTH, MINOR_SIXTH, MINOR_SEVENTH -> "b";
            case AUGMENTED_TONIC, AUGMENTED_SECOND, AUGMENTED_THIRD, AUGMENTED_FOURTH, AUGMENTED_FIFTH, AUGMENTED_SIXTH, AUGMENTED_SEVENTH -> "#";
            default -> "";
        };

        String romanNumeral = switch (distanceFromRoot.getScaleDegree()) {
            case TONIC -> "I";
            case SECOND -> "II";
            case THIRD -> "III";
            case FOURTH -> "IV";
            case FIFTH -> "V";
            case SIXTH -> "VI";
            case SEVENTH -> "VII";
        };
        return prefix + romanNumeral;
    }

    public static Interval resolveIntervalUpInKeyContext(Interval rootInterval, Interval distanceForward) {
        // Find the canonical scale degree which describes the resulting interval
        int canonicalTargetRoot = (rootInterval.getCanonicalScaleDegree() + distanceForward.getCanonicalScaleDegree()) % 12;

        // Find the named scale degree which describes which of the seven scale degrees we end up on
        List<ScaleDegree> scaleDegrees = Arrays.asList(ScaleDegree.values());
        ScaleDegree rootScaleDegree = rootInterval.getScaleDegree();
        int canonicalDegreesTraversed = distanceForward.getScaleDegree().getNumber() - 1;
        int endingDegreeIndex = (scaleDegrees.indexOf(rootScaleDegree) + (canonicalDegreesTraversed)) % 7;
        ScaleDegree endingScaleDegrees = scaleDegrees.get(endingDegreeIndex);

        // Find the interval which corresponds to the resulting canonical scale degree and named scale degree
        for (Interval interval : Interval.values()) {
            if (interval.getScaleDegree() == endingScaleDegrees && interval.getCanonicalScaleDegree() == canonicalTargetRoot) {
                return interval;
            }
        }
        throw new IllegalArgumentException("Could not determine interval ascended. From: " + rootInterval + ", distance: " + distanceForward);
    }

    public static Interval resolveIntervalDownInKeyContext(Interval rootInterval, Interval distanceBackward) {
        // Find the canonical scale degree which describes the resulting interval
        int canonicalTargetRoot = ((rootInterval.getCanonicalScaleDegree() + 12) - distanceBackward.getCanonicalScaleDegree()) % 12;

        // Find the named scale degree which describes which of the seven scale degrees we end up on
        List<ScaleDegree> scaleDegrees = Arrays.asList(ScaleDegree.values());
        ScaleDegree rootScaleDegree = rootInterval.getScaleDegree();
        int canonicalDegreesTraversed = distanceBackward.getScaleDegree().getNumber() - 1;
        int endingDegreeIndex = ((scaleDegrees.indexOf(rootScaleDegree) + 7) - (canonicalDegreesTraversed)) % 7;
        ScaleDegree endingScaleDegrees = scaleDegrees.get(endingDegreeIndex);

        // Find the interval which corresponds to the resulting canonical scale degree and named scale degree
        for (Interval interval : Interval.values()) {
            if (interval.getScaleDegree() == endingScaleDegrees && interval.getCanonicalScaleDegree() == canonicalTargetRoot) {
                return interval;
            }
        }
        throw new IllegalArgumentException("Could not determine interval descended. From: " + rootInterval + ", distance: " + distanceBackward);
    }
}
