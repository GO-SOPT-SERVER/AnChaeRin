package sopt.org.ThirdSeminar.controller.post.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResisterResponseDto {
    final private Long id;
    final private Long userId;
    final private String title;
    final private String content;

    public static ResisterResponseDto of(Long postId, Long userId, String title, String content) {
        return new ResisterResponseDto(postId, userId, title, content);
    }
}
