package sopt.org.secondSeminar.controller.post.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EditRequestDto {
    final private String title;
    final private String content;
}
