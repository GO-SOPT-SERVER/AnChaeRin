package sopt.org.fouthSeminar.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginResponseDto {
    private String accessToken;
    private String refreshToken;

    public static UserLoginResponseDto of(String accessToken, String refreshToken) {
        return new UserLoginResponseDto(accessToken, refreshToken);
    }
}