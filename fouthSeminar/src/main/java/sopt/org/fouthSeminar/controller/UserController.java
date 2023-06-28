package sopt.org.fouthSeminar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fouthSeminar.config.jwt.JwtService;
import sopt.org.fouthSeminar.controller.dto.*;
import sopt.org.fouthSeminar.exception.Success;
import sopt.org.fouthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "유저 API Document")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 생성 API", description = "유저를 서버에 등록합니다.")
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저 로그인 API", description = "유저가 서버에 로그인을 요청합니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String refreshToken = userService.generateRefreshToken(userId);
        final String accessToken = userService.generateAccessToken(refreshToken);
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(accessToken, refreshToken));
    }

    @PostMapping("/token/refresh")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "token refresh API", description = "access token을 재발급 합니다.")
    public ApiResponse<TokenRefreshResponseDto> refreshToken(@RequestBody @Valid final TokenRefreshRequestDto request) {
        final String accessToken = userService.generateAccessToken(request.getRefreshToken());
        return ApiResponse.success(Success.TOKEN_REFRESH_SUCCESS, TokenRefreshResponseDto.of(accessToken));
    }
}
