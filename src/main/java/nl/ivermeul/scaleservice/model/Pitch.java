package nl.ivermeul.scaleservice.model;

import java.util.List;

/**
 * The pitch of a musical note
 */
public class Pitch {
    private static final List<Pitch> availablePitches = List.of(
            new Pitch("C"),
            new Pitch("C-sharp", "D-flat"),
            new Pitch("D"),
            new Pitch("D-sharp", "E-flat"),
            new Pitch("E"),
            new Pitch("F"),
            new Pitch("F-sharp", "G-flat"),
            new Pitch("G"),
            new Pitch("G-sharp", "A-flat"),
            new Pitch("A"),
            new Pitch("A-sharp", "B-flat"),
            new Pitch("B"));

    private List<String> names;

    private Pitch(final String... names) {
        this.names = List.of(names);
    }

    public static Pitch valueOf(String name) {
        return availablePitches.stream()
                .filter(pitch -> pitch.getNames().contains(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Pitch with name %s does not exist", name)));
    }

    public List<String> getNames() {
        return names;
    }
}
