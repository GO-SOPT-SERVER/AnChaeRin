package sopt.org.ThirdSeminar.controller.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;

    public static PostResponseDto of(Long postId, Long userId, String title,String content) {
        return new PostResponseDto(postId,userId,title,content);
    }
}
