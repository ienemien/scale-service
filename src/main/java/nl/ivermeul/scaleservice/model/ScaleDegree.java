package nl.ivermeul.scaleservice.model;

import nl.ivermeul.scaleservice.exceptions.ScaleDegreeNotFoundException;

import java.util.Arrays;

public enum ScaleDegree {
    TONIC(1),
    SUPERTONIC(2),
    MEDIANT(3),
    SUBDOMINANT(4),
    DOMINANT(5),
    SUBMEDIANT(6),
    LEADING_TONE(7);

    private int number;

    ScaleDegree(int number) {
        this.number = number;
    }

    public static ScaleDegree findDegreeByNumber(int number) {
        return Arrays.stream(ScaleDegree.values())
                .filter(degree -> degree.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new ScaleDegreeNotFoundException(String.format("Degree with number %d does not exist", number)));
    }

    public int getNumber() {
        return number;
    }

}
