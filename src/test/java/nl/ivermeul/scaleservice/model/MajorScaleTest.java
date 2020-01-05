package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MajorScaleTest {

    @Test
    void getPitchOfCMajorScaleDegree1() {
        Scale cMajorScale = new MajorScale(Pitch.C);
        Pitch result = cMajorScale.getPitchByDegree(ScaleDegree.FIRST);
        assertThat(result, is(Pitch.C));
    }

    @Test
    void getPitchOfCMajorScaleDegree7() {
        Scale cMajorScale = new MajorScale(Pitch.C);
        Pitch result = cMajorScale.getPitchByDegree(ScaleDegree.SEVENTH);
        assertThat(result, is(Pitch.B));
    }

    @Test
    void getPitches() {
    }

    @Test
    void getPitchesAsString() {
    }
}