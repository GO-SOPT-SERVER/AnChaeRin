package sopt.org.fouthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fouthSeminar.controller.dto.UserLoginRequestDto;
import sopt.org.fouthSeminar.controller.dto.UserRequestDto;
import sopt.org.fouthSeminar.controller.dto.UserResponseDto;
import sopt.org.fouthSeminar.domain.User;
import sopt.org.fouthSeminar.exception.Error;
import sopt.org.fouthSeminar.exception.model.BadRequestException;
import sopt.org.fouthSeminar.exception.model.ConflictException;
import sopt.org.fouthSeminar.exception.model.NotFoundException;
import sopt.org.fouthSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserResponseDto.of(newUser.getId(), newUser.getNickname());
    }

    @Transactional
    public Long login(UserLoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException(Error.INVALID_PASSWORD_EXCEPTION, Error.INVALID_PASSWORD_EXCEPTION.getMessage());
        }

        return user.getId();
    }
}