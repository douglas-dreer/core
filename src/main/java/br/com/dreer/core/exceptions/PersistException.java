package br.com.dreer.core.exceptions;

public class PersistException extends RuntimeException {

    public PersistException(String message) {
        super(message);
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
