package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.post.dto.response.ResisterResponseDto;
import sopt.org.ThirdSeminar.controller.user.dto.request.SignupRequestDto;
import sopt.org.ThirdSeminar.domain.Post;
import sopt.org.ThirdSeminar.domain.User;
import sopt.org.ThirdSeminar.exception.CustomException;
import sopt.org.ThirdSeminar.exception.ErrorStatus;
import sopt.org.ThirdSeminar.infrastructure.PostRepository;
import sopt.org.ThirdSeminar.infrastructure.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResisterResponseDto create(Long userId, SignupRequestDto request) {
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new CustomException(ErrorStatus.USER_NOT_FOUND);
        }

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user.get())
                .build();

        postRepository.save(post);
        return ResisterResponseDto.of(post.getId(), user.get().getId(), post.getTitle(), post.getContent());

    }
}