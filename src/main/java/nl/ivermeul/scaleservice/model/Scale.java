package nl.ivermeul.scaleservice.model;

import java.util.Map;

public interface Scale {
    public Pitch getPitchByStep(int step);

    public Map<Integer, Pitch> getPitches(String root);

    public String getPitchesAsString(String root);
}
