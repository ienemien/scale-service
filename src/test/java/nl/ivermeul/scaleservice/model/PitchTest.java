package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class PitchTest {

    @Test
    void findPitchByNameC() {
        Pitch result = Pitch.findPitchByName("C");
        assertThat(result, is(equalTo(Pitch.C)));
    }

    @Test
    void findPitchByNameDFlat() {
        Pitch result = Pitch.findPitchByName("D-flat");
        assertThat(result, is(equalTo(Pitch.CSHARP)));
    }

    @Test
    void findPitchByRelativePosition() {
    }

    @Test
    void getNames() {
    }
}