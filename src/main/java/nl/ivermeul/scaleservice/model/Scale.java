package nl.ivermeul.scaleservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Scale {

    private Map<ScaleDegree, Pitch> pitchPerDegree;

    public Scale(Pitch tonic) {
        this.pitchPerDegree = calculatePitchesPerDegree(tonic);
    }

    protected abstract List<Integer> getHalfStepsPattern();

    /**
     * This is what the service will return
     *
     * @return The pitch per degree of the scale
     */
    @JsonCreator
    public Map<ScaleDegree, Pitch> getPitchesPerDegree() {
        return pitchPerDegree;
    }

    public Pitch findPitchByDegree(ScaleDegree degree) {
        Pitch pitch = pitchPerDegree.get(degree);
        Objects.requireNonNull(pitch);
        return pitch;
    }

    public String pitchesAsString() {
        return pitchPerDegree.values().stream()
                .map(pitch -> pitch.getNames().get(0))
                .collect(Collectors.joining(" "));
    }

    public Map<ScaleDegree, Pitch> calculatePitchesPerDegree(Pitch tonic) {
        Map<ScaleDegree, Pitch> pitchPerDegree = new LinkedHashMap<>();
        int halfStepsFromRoot = 0;
        for (int i = 0; i < ScaleDegree.values().length; i++) {
            pitchPerDegree.put(ScaleDegree.findDegreeByNumber(i + 1), Pitch.findPitchByRelativePosition(tonic, halfStepsFromRoot));
            halfStepsFromRoot += getHalfStepsPattern().get(i);
        }
        return pitchPerDegree;
    }

}
