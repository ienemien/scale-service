package nl.ivermeul.scaleservice.model;

import java.util.Arrays;
import java.util.List;

/**
 * The pitch of a musical note
 */
public enum Pitch {
    C(1, "C"),
    CSHARP(2, "C-sharp", "D-flat"),
    D(3, "D"),
    DSHARP(4, "D-sharp", "E-flat"),
    E(5, "E"),
    F(6, "F"),
    FSHARP(7, "F-sharp", "G-flat"),
    G(8, "G"),
    GSHARP(9, "G-sharp", "A-flat"),
    A(10, "A"),
    SHARP(11, "A-sharp", "B-flat"),
    B(12, "B");

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
//        int wantedPos =
//        return Arrays.stream(Pitch.values())
//                .filter(pitch -> pitch.getPosition == position)
        return Pitch.C;
    }

    public List<String> getNames() {
        return names;
    }
}
