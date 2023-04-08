package sopt.org.secondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.secondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.secondSeminar.domain.Post;

import static sopt.org.secondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long register(RegisterRequestDto request) {
        Post newPost = new Post(
                request.getTitle(),
                request.getContent()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        // 저장한 유저 아이디 값 반환
        return newPost.getId();
    }

    public String search(Long id) {
        Post searchedPost = postList.stream().filter(post -> post.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException());
        return searchedPost.toString();
    }
}
