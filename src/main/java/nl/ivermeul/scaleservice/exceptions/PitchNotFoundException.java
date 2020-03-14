package nl.ivermeul.scaleservice.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PitchNotFoundException extends RuntimeException {
    public PitchNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
