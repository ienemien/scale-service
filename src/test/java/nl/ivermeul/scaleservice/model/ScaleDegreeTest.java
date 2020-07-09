package nl.ivermeul.scaleservice.model;

import nl.ivermeul.scaleservice.exceptions.ScaleDegreeNotFoundException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScaleDegreeTest {

    @Test
    void findDegreeByNumber7() {
        ScaleDegree result = ScaleDegree.findDegreeByNumber(7);
        assertThat(result, is(ScaleDegree.LEADING_TONE));
    }

    @Test
    void findDegreeByNumber1() {
        ScaleDegree result = ScaleDegree.findDegreeByNumber(1);
        assertThat(result, is(ScaleDegree.TONIC));
    }

    @Test
    void findDegreeByNumberThrowsExceptionIfNumberNotFound() {
        Exception exception = assertThrows(ScaleDegreeNotFoundException.class, () -> ScaleDegree.findDegreeByNumber(8));
        assertThat(exception.getMessage(), containsString("8"));
    }
}