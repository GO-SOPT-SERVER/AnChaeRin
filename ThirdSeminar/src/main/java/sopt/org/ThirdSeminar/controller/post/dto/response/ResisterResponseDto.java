package sopt.org.ThirdSeminar.controller.post.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResisterResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String content;

    public static ResisterResponseDto of(Long postId, Long userId, String title, String content) {
        return new ResisterResponseDto(postId, userId, title, content);
    }
}
