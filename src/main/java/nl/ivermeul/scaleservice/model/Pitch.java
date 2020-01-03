package nl.ivermeul.scaleservice.model;

import java.util.Arrays;
import java.util.List;

/**
 * The pitch of a musical note
 */
public enum Pitch {
    C(0, "C"),
    CSHARP(1, "C-sharp", "D-flat"),
    D(2, "D"),
    DSHARP(3, "D-sharp", "E-flat"),
    E(4, "E"),
    F(5, "F"),
    FSHARP(6, "F-sharp", "G-flat"),
    G(7, "G"),
    GSHARP(8, "G-sharp", "A-flat"),
    A(9, "A"),
    ASHARP(10, "A-sharp", "B-flat"),
    B(11, "B");

    private final List<String> names;
    private final int position;

    /**
     * The pitch of a note
     *
     * @param position Position keyboard in half steps, starting at C
     * @param name     The name of the pitch, if there is only one
     */
    Pitch(int position, String name) {
        this.names = List.of(name);
        this.position = position;
    }

    /**
     * The pitch of a note
     *
     * @param position Position on C major scale
     * @param name     The name of the pitch
     * @param name2    The second name of the pitch
     */
    Pitch(int position, String name, String name2) {
        this.names = List.of(name, name2);
        this.position = position;
    }

    public static Pitch findPitchByName(String name) {
        return Arrays.stream(Pitch.values())
                .filter(pitch -> pitch.getNames().contains(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Pitch with name %s does not exist", name)));
    }

    public static Pitch findPitchByRelativePosition(Pitch root, int relativePos) {
        int wantedPos = (root.position + relativePos) % 12;
        return Arrays.stream(Pitch.values())
                .filter(pitch -> pitch.position == wantedPos)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Pitch with root name %s and relative position %d does not exist.",
                                root.getNames().get(0), relativePos)));
    }

    public List<String> getNames() {
        return names;
    }

    public int getPosition() {
        return position;
    }
}
