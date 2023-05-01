package sopt.org.secondSeminar.controller.user.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterRequestDto {
    final private String gender;
    final private String name;
    final private String contact;
    final private int age;
}
