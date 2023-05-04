package sopt.org.ThirdSeminar.controller.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SearchResponseDto {
    private Long id;
    private String title;
    private String content;
}

