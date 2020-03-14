package nl.ivermeul.scaleservice.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScaleTypeNotFound extends RuntimeException {
    public ScaleTypeNotFound(String message) {
        super(message);
        log.error(message);
    }
}
