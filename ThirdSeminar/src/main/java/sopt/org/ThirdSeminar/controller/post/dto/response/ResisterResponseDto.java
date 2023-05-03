package sopt.org.ThirdSeminar.controller.post.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResisterResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;

    public static ResisterResponseDto of(Long postId, Long userId, String title, String content) {
        return new ResisterResponseDto(postId, userId, title, content);
    }
}
