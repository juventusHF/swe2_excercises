package ch.juventus.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public PersonNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
