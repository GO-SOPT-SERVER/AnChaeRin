package sopt.org.ThirdSeminar.common.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.ThirdSeminar.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminar.exception.CustomException;
import sopt.org.ThirdSeminar.exception.ErrorStatus;

import static sopt.org.ThirdSeminar.common.dto.ApiResponseDto.error;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomException.class)
    protected ApiResponseDto handleUserNotFoundException(final CustomException e) {
        return error(ErrorStatus.USER_NOT_FOUND);
    }

}
