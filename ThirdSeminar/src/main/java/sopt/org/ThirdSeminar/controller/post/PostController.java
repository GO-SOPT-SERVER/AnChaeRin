package sopt.org.ThirdSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdSeminar.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminar.controller.post.dto.response.ResisterResponseDto;
import sopt.org.ThirdSeminar.controller.post.dto.response.SearchResponseDto;
import sopt.org.ThirdSeminar.controller.user.dto.request.SignupRequestDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.PostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public ApiResponseDto<List<SearchResponseDto>> search(@RequestParam final Long user_id) {
        return ApiResponseDto.success(SuccessStatus.POST_SEARCH_SUCCESS, postService.search(user_id));
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<ResisterResponseDto> create(@RequestParam final Long user_id, @RequestBody @Valid final SignupRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.POST_REGISTER_SUCCESS, postService.create(user_id, request));
    }
}