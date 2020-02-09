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
}
