package sopt.org.fouthSeminar.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fouthSeminar.controller.dto.UserLoginRequestDto;
import sopt.org.fouthSeminar.controller.dto.UserRequestDto;
import sopt.org.fouthSeminar.controller.dto.UserResponseDto;
import sopt.org.fouthSeminar.domain.RefreshToken;
import sopt.org.fouthSeminar.domain.User;
import sopt.org.fouthSeminar.exception.Error;
import sopt.org.fouthSeminar.exception.model.BadRequestException;
import sopt.org.fouthSeminar.exception.model.ConflictException;
import sopt.org.fouthSeminar.exception.model.NotFoundException;
import sopt.org.fouthSeminar.infrastructure.RefreshTokenRepository;
import sopt.org.fouthSeminar.infrastructure.UserRepository;
import sopt.org.fouthSeminar.exception.model.InvalidRefreshTokenException;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    private static final String SECRET_KEY = "abcdefgabcdefgabcdefgabcdefgabcdefgabcdefg";
    private static final int ACCESS_TOKEN_EXPIRES = 30000;
    private final SecretKey secretKey;

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public UserService(final UserRepository userRepository,
                        final RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

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

    public RefreshToken generateRefreshToken(final Long userId) {
        RefreshToken refreshToken = new RefreshToken(UUID.randomUUID().toString(), userId);
        refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }

    public String generateAccessToken(final String refreshTokenId) {
        RefreshToken refreshToken = refreshTokenRepository.findById(refreshTokenId)
                .orElseThrow(()->new InvalidRefreshTokenException(Error.INVALID_REFRESH_TOKEN_EXCEPTION,"유효하지 않은 리프레시 토큰"));
        Long memberId = refreshToken.getMemberId();

        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_EXPIRES);

        String accessToken = Jwts.builder()
                .signWith(secretKey)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .setSubject(String.valueOf(memberId))
                .compact();

        return accessToken;
    }
}