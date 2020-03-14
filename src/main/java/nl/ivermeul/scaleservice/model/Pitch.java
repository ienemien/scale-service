package nl.ivermeul.scaleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import nl.ivermeul.scaleservice.exceptions.PitchNotFoundException;

import java.util.Arrays;
import java.util.List;

/**
 * The pitch of a musical note
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Pitch {
    C(0, List.of("C")),
    CSHARP(1, List.of("C-sharp", "D-flat")),
    D(2, List.of("D")),
    DSHARP(3, List.of("D-sharp", "E-flat")),
    E(4, List.of("E")),
    F(5, List.of("F")),
    FSHARP(6, List.of("F-sharp", "G-flat")),
    G(7, List.of("G")),
    GSHARP(8, List.of("G-sharp", "A-flat")),
    A(9, List.of("A")),
    ASHARP(10, List.of("A-sharp", "B-flat")),
    B(11, List.of("B"));

    private final List<String> names;
    private final int position;

    /**
     * The pitch of a note
     *
     * @param position Position keyboard in half steps, starting at C
     * @param names    A list with the name or names of the notes
     */
    Pitch(int position, List<String> names) {
        this.names = names;
        this.position = position;
    }

    public static Pitch findPitchByName(String name) {
        return Arrays.stream(Pitch.values())
                .filter(pitch -> pitch.getNames().contains(name))
                .findFirst()
                .orElseThrow(() -> new PitchNotFoundException(String.format("Pitch with name %s does not exist", name)));
    }

    public static Pitch findPitchByRelativePosition(Pitch root, int relativePos) {
        int wantedPos = (root.position + relativePos) % 12;
        return Arrays.stream(Pitch.values())
                .filter(pitch -> pitch.position == wantedPos)
                .findFirst()
                .orElseThrow(() -> new PitchNotFoundException(
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
