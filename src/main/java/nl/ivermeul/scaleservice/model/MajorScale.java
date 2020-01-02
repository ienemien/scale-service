package nl.ivermeul.scaleservice.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorScale implements Scale {

    // W-W-H-W-W-W-H
    private static List<Integer> halfSteps = List.of(2, 2, 1, 2, 2, 2, 1);
    private Map<Integer, Pitch> pitchPerStep;

    public MajorScale(Pitch root) {
        pitchPerStep = new HashMap<>();
        pitchPerStep.put(1, root);
        int halfStepsFromRoot = 0;
        for (int i = 0; i < 7; i++) {
            halfStepsFromRoot += halfSteps.get(i);
            pitchPerStep.put(i, Pitch.findPitchByRelativePosition(root, halfStepsFromRoot));
        }
    }

    @Override
    public Pitch getPitchByStep(int step) {
        return pitchPerStep.get(step);
    }

    @Override
    public Map<Integer, Pitch> getPitches(String root) {
        return pitchPerStep;
    }

    @Override
    public String getPitchesAsString(String root) {
        throw new UnsupportedOperationException();
    }
}
