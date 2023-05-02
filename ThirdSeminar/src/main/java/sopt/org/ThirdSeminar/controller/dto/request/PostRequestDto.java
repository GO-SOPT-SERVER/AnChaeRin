package sopt.org.ThirdSeminar.controller.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class PostRequestDto {

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,30}$", message = "제목 형식에 맞지 않습니다.")
    private final String title;

    @NotBlank
    private final String content;
}

