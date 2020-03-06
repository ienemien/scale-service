//todo: fix tests
package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MajorScaleTest {

    @Test
    void getPitchOfCMajorScaleDegree1() {
        Scale cMajorScale = new MajorScale(Pitch.C);
        Pitch result = cMajorScale.findPitchByDegree(ScaleDegree.FIRST);
        assertThat(result, is(Pitch.C));
    }

    @Test
    void getPitchOfCMajorScaleDegree7() {
        Scale cMajorScale = new MajorScale(Pitch.C);
        Pitch result = cMajorScale.findPitchByDegree(ScaleDegree.SEVENTH);
        assertThat(result, is(Pitch.B));
    }

    @Test
    void getPitchesOfCAsString() {
        Scale cMajorScale = new MajorScale(Pitch.C);
        String result = cMajorScale.pitchesAsString();
        assertThat(result, is(equalTo("C D E F G A B")));
    }

    @Test
    void getPitchesOfBAsString() {
        Scale cMajorScale = new MajorScale(Pitch.B);
        String result = cMajorScale.pitchesAsString();

        assertThat(result, is(equalTo("B C-sharp D-sharp E F-sharp G-sharp A-sharp")));
    }

    @Test
    void getPitchesOfGsharpAsString() {
        Scale cMajorScale = new MajorScale(Pitch.GSHARP);
        String result = cMajorScale.pitchesAsString();

        assertThat(result, is(equalTo("G-sharp A-sharp C C-sharp D-sharp F G")));
    }
}
