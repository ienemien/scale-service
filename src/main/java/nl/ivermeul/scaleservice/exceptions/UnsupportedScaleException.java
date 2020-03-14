package nl.ivermeul.scaleservice.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnsupportedScaleException extends RuntimeException {

    public UnsupportedScaleException(String message) {
        super(message);
        log.error(message);
    }
}