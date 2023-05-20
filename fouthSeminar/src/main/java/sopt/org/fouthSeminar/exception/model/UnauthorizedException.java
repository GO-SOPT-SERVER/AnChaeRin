package sopt.org.fouthSeminar.exception.model;

import lombok.Getter;
import sopt.org.fouthSeminar.exception.Error;

public class UnauthorizedException extends SoptException {
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}

