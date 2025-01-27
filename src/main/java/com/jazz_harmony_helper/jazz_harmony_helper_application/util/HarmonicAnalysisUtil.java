package com.jazz_harmony_helper.jazz_harmony_helper_application.util;

import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.chord.ChordQuality;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicAnalysisDrivenChordSetAbstract;
import com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicClassification;
import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;

import static com.jazz_harmony_helper.jazz_harmony_helper_application.harmonic_analysis_driven_chord_set.HarmonicClassification.*;

public class HarmonicAnalysisUtil {

    private HarmonicAnalysisUtil() {

    }

    public static String getChordAnalysis(
            HarmonicAnalysisDrivenChordSetAbstract harmChordAbstract,
            ChordAbstract chordAbstract
    ) {
        ChordQuality chordQuality = chordAbstract.getChordQuality();
        HarmonicClassification classification = harmChordAbstract.getHarmonicClassification();

        if (classification == SECONDARY_DOMINANT) {
            Interval target = resolveKeyLocationDownIntervalDistance(
                    harmChordAbstract.getDistanceFromKeyRoot(),
                    Interval.PERFECT_FIFTH
            );
            return "V/" + getRomanNumeral(target);
        } else if (classification == SUBSTITUTE_DOMINANT) {
            Interval target = resolveKeyLocationDownIntervalDistance(
                    harmChordAbstract.getDistanceFromKeyRoot(),
                    Interval.MINOR_SECOND
            );
            return "SubV/" + getRomanNumeral(target);
        } else if (classification == SECONDARY_PREDOMINANT) {
            Interval target = resolveKeyLocationDownIntervalDistance(
                    harmChordAbstract.getDistanceFromKeyRoot(), Interval.MAJOR_SECOND);
            return "ii" + chordQuality.getRepresentation() + "/" + getRomanNumeral(target);
        }

        Interval distanceFromRoot = harmChordAbstract.getDistanceFromKeyRoot();
        String analysis = getRomanNumeral(distanceFromRoot);

        if (chordQuality.getIntervals().contains(Interval.MINOR_THIRD)) {
            analysis = analysis.toLowerCase();
        }

        return analysis + chordQuality.getRepresentation();
    }

    protected static String getRomanNumeral(Interval intervalDistanceFromRoot) {
        String prefix = switch (intervalDistanceFromRoot) {
            case MINOR_SECOND, MINOR_THIRD, DIMINISHED_FIFTH, MINOR_SIXTH, MINOR_SEVENTH -> "b";
            case AUGMENTED_TONIC, AUGMENTED_SECOND, AUGMENTED_FOURTH, AUGMENTED_FIFTH -> "#";
            case TONIC, MAJOR_SECOND, MAJOR_THIRD, PERFECT_FOURTH, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SEVENTH -> "";
            default -> throw new RuntimeException("Unsupported chord root: " + intervalDistanceFromRoot.name());
        };

        String romanNumeral = switch (intervalDistanceFromRoot.getScaleDegree()) {
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

    protected static Interval resolveKeyLocationUpIntervalDistance(
            Interval locationDistanceFromKeyRoot,
            Interval distanceForward
    ) {
        // Find the ending scale degree
        int scaleDegreesTraversed = distanceForward.getScaleDegree().getNumber() - 1;
        int startingScaleDegree = locationDistanceFromKeyRoot.getScaleDegree().getNumber();
        int endingScaleDegree = startingScaleDegree + scaleDegreesTraversed;
        endingScaleDegree = endingScaleDegree > 7 ? endingScaleDegree - 7 : endingScaleDegree;

        // Find ending semitone steps from key root
        int endingSemitoneStepsFromKeyRoot = (locationDistanceFromKeyRoot.getSemitoneSteps() + distanceForward.getSemitoneSteps()) % 12;

        for (Interval interval : Interval.values()) {
            if (interval.getScaleDegree().getNumber() == endingScaleDegree && interval.getSemitoneSteps() == endingSemitoneStepsFromKeyRoot) {
                return interval;
            }
        }

        throw new IllegalArgumentException("Could not determine interval ascended. From: " + locationDistanceFromKeyRoot + ", distance: " + distanceForward);
    }

    protected static Interval resolveKeyLocationDownIntervalDistance(
            Interval locationDistanceFromKeyRoot,
            Interval distanceBackward
    ) {
        // find the ending scale degree
        int scaleDegreesTraversed = distanceBackward.getScaleDegree().getNumber() - 1;
        int startingScaleDegree = locationDistanceFromKeyRoot.getScaleDegree().getNumber();
        int endingScaleDegree = (startingScaleDegree + 7) - scaleDegreesTraversed;
        endingScaleDegree = endingScaleDegree > 7 ? endingScaleDegree - 7 : endingScaleDegree;

        // Find ending semitone steps from key root
        int endingSemitoneStepsFromKeyRoot = ((locationDistanceFromKeyRoot.getSemitoneSteps() + 12) - distanceBackward.getSemitoneSteps()) % 12;

        for (Interval interval : Interval.values()) {
            if (interval.getScaleDegree().getNumber() == endingScaleDegree && interval.getSemitoneSteps() == endingSemitoneStepsFromKeyRoot) {
                return interval;
            }
        }

        throw new IllegalArgumentException("Could not determine interval descended. From: " + locationDistanceFromKeyRoot + ", distance: " + distanceBackward);
    }
}
