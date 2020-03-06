package nl.ivermeul.scaleservice.model;

import java.util.List;

public class NaturalMinorScale extends Scale {

    // whole, half, whole, whole, half, whole, whole
    private static List<Integer> halfStepsPattern = List.of(2, 1, 2, 2, 1, 2, 2);

    public NaturalMinorScale(Pitch tonic) {
        super(tonic);
    }

    @Override
    protected List<Integer> getHalfStepsPattern() {
        return halfStepsPattern;
    }

}
