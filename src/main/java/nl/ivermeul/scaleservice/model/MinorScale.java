package nl.ivermeul.scaleservice.model;

import java.util.Map;

public class MinorScale implements Scale {
    @Override
    public Pitch getPitchByStep(int step) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<Integer, Pitch> getPitches(String root) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPitchesAsString(String root) {
        throw new UnsupportedOperationException();
    }
}
