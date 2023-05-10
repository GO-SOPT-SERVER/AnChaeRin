package sopt.org.fouthSeminar.exception.model;

import sopt.org.fouthSeminar.exception.Error;
public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
