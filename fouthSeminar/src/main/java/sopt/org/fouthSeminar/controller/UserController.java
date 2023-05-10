package sopt.org.fouthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fouthSeminar.controller.dto.ApiResponse;
import sopt.org.fouthSeminar.controller.dto.UserRequestDto;
import sopt.org.fouthSeminar.controller.dto.UserResponseDto;
import sopt.org.fouthSeminar.exception.Success;
import sopt.org.fouthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }
}
