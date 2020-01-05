package nl.ivermeul.scaleservice.model;

import java.util.Arrays;

public enum ScaleDegree {
    FIRST(1, "Tonic"),
    SECOND(2, "Supertonic"),
    THIRD(3, "Mediant"),
    FOURTH(4, "Subdominant"),
    FIFTH(5, "Dominant"),
    SIXTH(6, "Submediant"),
    SEVENTH(7, "Leading Tone");

    private int number;
    private String name;

    ScaleDegree(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static ScaleDegree findDegreeByNumber(int number) {
        return Arrays.stream(ScaleDegree.values())
                .filter(degree -> degree.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Degree with number %d does not exist", number)));
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
