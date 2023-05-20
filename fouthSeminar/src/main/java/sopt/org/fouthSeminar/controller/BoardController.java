package sopt.org.fouthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fouthSeminar.config.jwt.JwtService;
import sopt.org.fouthSeminar.controller.dto.ApiResponse;
import sopt.org.fouthSeminar.controller.dto.BoardRequestDto;
import sopt.org.fouthSeminar.exception.Success;
import sopt.org.fouthSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {


    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @RequestHeader("Authorization") String accessToken,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)), request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
