package nl.ivermeul.scaleservice.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScaleDegreeTest {

    @Test
    void findDegreeByNumber7() {
        ScaleDegree result = ScaleDegree.findDegreeByNumber(7);
        assertThat(result, is(ScaleDegree.SEVENTH));
    }

    @Test
    void findDegreeByNumber1() {
        ScaleDegree result = ScaleDegree.findDegreeByNumber(1);
        assertThat(result, is(ScaleDegree.FIRST));
    }

    @Test
    void findDegreeByNumberThrowsExceptionIfNumberNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ScaleDegree.findDegreeByNumber(8));
        assertThat(exception.getMessage(), containsString("8"));
    }
}