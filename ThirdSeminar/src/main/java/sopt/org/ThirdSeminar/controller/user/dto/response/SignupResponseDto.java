package sopt.org.ThirdSeminar.controller.user.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponseDto {
    private Long userId;
    private String nickname;

    public static SignupResponseDto of(Long userId, String nickname) {
        return new SignupResponseDto(userId, nickname);
    }
}
