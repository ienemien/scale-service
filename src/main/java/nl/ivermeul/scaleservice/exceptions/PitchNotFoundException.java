package nl.ivermeul.scaleservice.exceptions;

public class PitchNotFoundException extends RuntimeException {
    public PitchNotFoundException(String message) {
        super(message);
    }
}
