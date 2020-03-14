package nl.ivermeul.scaleservice.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleDegreeNotFoundException extends RuntimeException {
    public ScaleDegreeNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
