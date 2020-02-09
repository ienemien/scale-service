package nl.ivermeul.scaleservice.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MajorScale implements Scale {

    // W-W-H-W-W-W-H
    private static List<Integer> halfStepsPattern = List.of(2, 2, 1, 2, 2, 2, 1);

    private Map<ScaleDegree, Pitch> pitchPerDegree;

    public MajorScale(Pitch tonic) {
        this.pitchPerDegree = calculatePitchesPerDegree(tonic);
    }

    @Override
    public Pitch findPitchByDegree(ScaleDegree degree) {
        Pitch pitch = pitchPerDegree.get(degree);
        Objects.requireNonNull(pitch);
        return pitch;
    }

    @Override
    public String pitchesAsString() {
        return pitchPerDegree.values().stream()
                .map(pitch -> pitch.getNames().get(0))
                .collect(Collectors.joining(" "));
    }

    @Override
    public Map<ScaleDegree, Pitch> getPitchesPerDegree() {
        return pitchPerDegree;
    }

    private static Map<ScaleDegree, Pitch> calculatePitchesPerDegree(Pitch tonic) {
        Map<ScaleDegree, Pitch> pitchPerDegree = new LinkedHashMap<>();
        int halfStepsFromRoot = 0;
        for (int i = 0; i < ScaleDegree.values().length; i++) {
            pitchPerDegree.put(ScaleDegree.findDegreeByNumber(i + 1), Pitch.findPitchByRelativePosition(tonic, halfStepsFromRoot));
            halfStepsFromRoot += halfStepsPattern.get(i);
        }
        return pitchPerDegree;
    }

}
