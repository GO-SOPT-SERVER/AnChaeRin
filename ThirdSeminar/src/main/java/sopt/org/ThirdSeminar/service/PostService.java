package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.post.dto.response.ResisterResponseDto;
import sopt.org.ThirdSeminar.controller.post.dto.response.SearchResponseDto;
import sopt.org.ThirdSeminar.controller.user.dto.request.SignupRequestDto;
import sopt.org.ThirdSeminar.domain.Post;
import sopt.org.ThirdSeminar.domain.User;
import sopt.org.ThirdSeminar.exception.CustomException;
import sopt.org.ThirdSeminar.exception.ErrorStatus;
import sopt.org.ThirdSeminar.infrastructure.PostRepository;
import sopt.org.ThirdSeminar.infrastructure.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<SearchResponseDto> search(Long userId) {
        System.out.println(userId);
        List<Post> postList = postRepository.findAll().stream()
                .filter(post -> post.getUser().getId().equals(userId))
                .collect(Collectors.toList());

        List<SearchResponseDto> postsResponseDtoList = new ArrayList<>();
        for (Post post : postList) {
            postsResponseDtoList.add(SearchResponseDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build());
        }

        return postsResponseDtoList;
    }
}