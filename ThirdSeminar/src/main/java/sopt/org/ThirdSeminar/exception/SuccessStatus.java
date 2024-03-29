package sopt.org.ThirdSeminar.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {
    /*
   user
    */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),

    /*
    post
     */
    POST_REGISTER_SUCCESS(HttpStatus.CREATED, "게시물 등록이 완료되었습니다."),
    POST_SEARCH_SUCCESS(HttpStatus.ACCEPTED, "게시물 검색이 완료되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
