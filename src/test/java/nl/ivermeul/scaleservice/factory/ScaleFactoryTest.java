package nl.ivermeul.scaleservice.factory;

import nl.ivermeul.scaleservice.model.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class ScaleFactoryTest {

    @Test
    void createMajorScale() {
        Scale scale = ScaleFactory.createScale("major", "B");

        assertThat(scale, instanceOf(MajorScale.class));
        assertThat(scale.getPitchesPerDegree().get(ScaleDegree.TONIC), is(equalTo(Pitch.B)));
    }

    @Test
    void createNaturalMinorScale() {
        Scale scale = ScaleFactory.createScale("natural-minor", "G");

        assertThat(scale, instanceOf(NaturalMinorScale.class));
        assertThat(scale.getPitchesPerDegree().get(ScaleDegree.TONIC), is(equalTo(Pitch.G)));
    }
}