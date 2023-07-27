package sopt.org.ThirdSeminar.controller.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignupResponseDto {
    private final Long userId;
    private final String nickname;

    public static SignupResponseDto of(Long userId, String nickname) {
        return new SignupResponseDto(userId, nickname);
    }
}
