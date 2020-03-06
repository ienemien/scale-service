package nl.ivermeul.scaleservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ScaleCreationException extends ResponseStatusException {

    public ScaleCreationException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
