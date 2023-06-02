package sopt.org.fouthSeminar.exception.model;

import sopt.org.fouthSeminar.exception.Error;

public class InvalidRefreshTokenException extends SoptException{
    public InvalidRefreshTokenException(Error error, String message) {
        super(error, message);
    }
}
