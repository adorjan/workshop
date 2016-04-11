package io.github.adorjan.exception;

public class KeyNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String MESSAGE = "The given key was not found.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
