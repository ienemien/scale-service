package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class NaturalMinorScaleTest {

    @Test
    void getPitchesOfCAsString() {
        Scale cNaturalMinorScale = new NaturalMinorScale(Pitch.C);
        String result = cNaturalMinorScale.pitchesAsString();

        assertThat(result, is(equalTo("C D D-sharp F G G-sharp A-sharp")));
    }

    @Test
    void getPitchesOfBAsString() {
        Scale cNaturalMinorScale = new NaturalMinorScale(Pitch.B);
        String result = cNaturalMinorScale.pitchesAsString();

        assertThat(result, is(equalTo("B C-sharp D E F-sharp G A")));
    }

    @Test
    void getPitchesOfGsharpAsString() {
        Scale cNaturalMinorScale = new NaturalMinorScale(Pitch.GSHARP);
        String result = cNaturalMinorScale.pitchesAsString();

        assertThat(result, is(equalTo("G-sharp A-sharp B C-sharp D-sharp E F-sharp")));
    }

}