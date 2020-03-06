package nl.ivermeul.scaleservice.factory;

import nl.ivermeul.scaleservice.model.*;

/**
 * Factory for creating scales by type and tonic (root note)
 */
public class ScaleFactory {

    /**
     * Create a scale by providing the name of the type and the name of the tonic (root note)
     *
     * @param typeName  The name of the type of scale, for available types see {@link ScaleType}
     * @param tonicName The name of the tonic (root note), for a list of available names see {@link Pitch}
     * @return a {@link Scale} of the given type and with the given tonic name
     */
    public static Scale createScale(String typeName, String tonicName) {
        Pitch tonic = Pitch.findPitchByName(tonicName);
        ScaleType type = ScaleType.getScaleTypeByName(typeName);

        return switch (type) {
            case MAJOR -> new MajorScale(tonic);
            case NATURAL_MINOR -> new NaturalMinorScale(tonic);
            case HARMONIC_MINOR, MELODIC_MINOR -> throw new UnsupportedOperationException("Scale type not yet supported.");
        };
    }
}
