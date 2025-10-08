package com.challenge.exceptions;

public class ExcepcionGeneral extends RuntimeException {
    public ExcepcionGeneral(String message) { super(message); }
    public ExcepcionGeneral(String message, Throwable cause) { super(message, cause); }
}
