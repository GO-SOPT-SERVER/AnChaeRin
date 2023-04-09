package sopt.org.secondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.secondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.secondSeminar.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String getDetail(Long id) {
        Post searchedPost = postList.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        return searchedPost.toString();
    }

    public List<Post> search(String title) {
        List<Post> searchedPostList = postList.stream()
                .filter(post -> post.getTitle().equals(title))
                .collect(Collectors.toList());

        return searchedPostList;
    }
}
