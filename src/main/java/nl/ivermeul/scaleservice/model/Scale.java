package nl.ivermeul.scaleservice.model;

import java.util.Map;

public interface Scale {

    Pitch findPitchByDegree(ScaleDegree degree);

    String pitchesAsString();

    Map<ScaleDegree, Pitch> getPitchesPerDegree();

}
