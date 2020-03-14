package nl.ivermeul.scaleservice.model;

import nl.ivermeul.scaleservice.exceptions.ScaleTypeNotFound;

import java.util.Arrays;

public enum ScaleType {
    MAJOR("major"),
    NATURAL_MINOR("natural-minor"),
    HARMONIC_MINOR("harmonic-minor"),
    MELODIC_MINOR("melodic-minor");

    private final String name;

    ScaleType(String name) {
        this.name = name;
    }

    public static ScaleType getScaleTypeByName(String name) {
        return Arrays.stream(ScaleType.values())
                .filter(value -> value.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ScaleTypeNotFound(String.format("Scale with name %s does not exist or is not supported.", name)));
    }

    public String getName() {
        return name;
    }
}
