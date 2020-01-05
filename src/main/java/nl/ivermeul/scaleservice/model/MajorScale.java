package nl.ivermeul.scaleservice.model;

import java.util.*;

public class MajorScale implements Scale {

    // W-W-H-W-W-W-H
    private static List<Integer> halfStepsPattern = List.of(2, 2, 1, 2, 2, 2, 1);
    private Map<ScaleDegree, Pitch> pitchPerDegree;

    public MajorScale(Pitch tonic) {
        pitchPerDegree = new HashMap<>();
        int halfStepsFromRoot = 0;
        for (int i = 0; i < ScaleDegree.values().length; i++) {
            pitchPerDegree.put(ScaleDegree.findDegreeByNumber(i + 1), Pitch.findPitchByRelativePosition(tonic, halfStepsFromRoot));
            halfStepsFromRoot += halfStepsPattern.get(i);
        }
    }

    @Override
    public Pitch getPitchByDegree(ScaleDegree degree) {
        Pitch pitch = pitchPerDegree.get(degree);
        Objects.requireNonNull(pitch);
        return pitch;
    }

    @Override
    public Map<ScaleDegree, Pitch> getPitches(String root) {
        return pitchPerDegree;
    }

    @Override
    public String getPitchesAsString(String root) {
        throw new UnsupportedOperationException();
    }
}
