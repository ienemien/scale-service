package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    void findPitchByRelativePositionCtoE() {
        Pitch result = Pitch.findPitchByRelativePosition(Pitch.C, 4);
        assertThat(result, is(equalTo(Pitch.E)));
    }

    @Test
    void findPitchByRelativePositionAtoDsharp() {
        Pitch result = Pitch.findPitchByRelativePosition(Pitch.A, 6);
        assertThat(result, is(equalTo(Pitch.DSHARP)));
    }

    @Test
    void findPitchByRelativePositionAsharpToAsharpAnOctaveHigher() {
        Pitch result = Pitch.findPitchByRelativePosition(Pitch.ASHARP, 12);
        assertThat(result, is(equalTo(Pitch.ASHARP)));
    }

    @Test
    void findPitchByRelativePositionFToBAnOctaveHigher() {
        Pitch result = Pitch.findPitchByRelativePosition(Pitch.F, 18);
        assertThat(result, is(equalTo(Pitch.B)));
    }

    @Test
    void getNames() {
        List<String> result = Pitch.CSHARP.getNames();
        assertThat(result,  containsInAnyOrder("C-sharp", "D-flat"));
    }
}