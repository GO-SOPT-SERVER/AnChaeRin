package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
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
    public PostResponseDto create(Long userId, PostRequestDto request) {
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
        return PostResponseDto.of(post.getId(), user.get().getId(), post.getTitle(), post.getContent());

    }
}