package nl.ivermeul.scaleservice.model;

import java.util.Map;

public interface Scale {
    Pitch getPitchByDegree(ScaleDegree degree);

    Map<ScaleDegree, Pitch> getPitches(String root);

    String getPitchesAsString(String root);
}
