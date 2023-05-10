package sopt.org.fouthSeminar.exception.model;

import sopt.org.fouthSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
