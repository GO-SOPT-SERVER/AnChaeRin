package sopt.org.fouthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.fouthSeminar.config.jwt.JwtService;
import sopt.org.fouthSeminar.config.resolver.UserId;
import sopt.org.fouthSeminar.controller.dto.ApiResponse;
import sopt.org.fouthSeminar.controller.dto.BoardImageListRequestDto;
import sopt.org.fouthSeminar.controller.dto.BoardRequestDto;
import sopt.org.fouthSeminar.exception.Success;
import sopt.org.fouthSeminar.external.client.aws.S3Service;
import sopt.org.fouthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@SecurityRequirement(name = "JWT Auth")
public class BoardController {


    private final S3Service s3Service;
    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardImageListRequestDto request) {
        List<String> boardThumbnailImageUrlList = s3Service.uploadImages(request.getBoardImages(), "board");
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
