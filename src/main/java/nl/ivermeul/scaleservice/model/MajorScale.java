package nl.ivermeul.scaleservice.model;

import java.util.List;

public class MajorScale extends Scale {

    // W-W-H-W-W-W-H
    private static List<Integer> halfStepsPattern = List.of(2, 2, 1, 2, 2, 2, 1);

    public MajorScale(Pitch tonic) {
        super(tonic);
    }

    @Override
    protected List<Integer> getHalfStepsPattern() {
        return halfStepsPattern;
    }

}
