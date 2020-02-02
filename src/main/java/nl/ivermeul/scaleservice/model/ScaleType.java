package nl.ivermeul.scaleservice.model;

import java.util.Arrays;

public enum ScaleType {
    MAJOR("Major"),
    NATURAL_MINOR("Natural Minor"),
    HARMONIC_MINOR("Harmonic Minor"),
    MELODIC_MINOR("Melodic Minor");

    private final String name;

    ScaleType(String name) {
        this.name = name;
    }

    public static ScaleType getScaleTypeByName(String name) {
        return Arrays.stream(ScaleType.values())
                .filter(value -> value.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Scale with name %s does not exist or is not supported.", name)));
    }

    public String getName() {
        return name;
    }
}
