package sopt.org.ThirdSeminar.controller.post.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class SearchResponseDto {
    private final Long id;
    private final String title;
    private final String content;
}

