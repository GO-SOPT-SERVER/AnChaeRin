package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.domain.Post;
import sopt.org.ThirdSeminar.infrastructure.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long create(PostRequestDto request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.save(post);

        return post.getId();
    }
}