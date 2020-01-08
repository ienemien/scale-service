package nl.ivermeul.scaleservice.model;

public interface Scale {
    Pitch getPitchByDegree(ScaleDegree degree);

    String getPitchesAsString();
}
