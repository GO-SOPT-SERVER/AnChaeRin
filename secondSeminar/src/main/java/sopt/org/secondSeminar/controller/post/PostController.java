package sopt.org.secondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.secondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.secondSeminar.service.PostService;

import static sopt.org.secondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable final Long postId) {
        System.out.println("요청 게시물 아이디: " + postId);
        postService.search(postId);

        return postService.search(postId);
    }

    @GetMapping("/post/search")
    public String search(@RequestParam final String title) {
        System.out.println("게시물 제목 검색 인자: " + title);

        return "게시물 검색 성공";
    }

    @PostMapping("/post")
    public String register(@RequestBody final RegisterRequestDto request) {
        // 서비스 계층에 유저를 등록하는 메서드를 호출
        Long postId = postService.register(request);
        System.out.println(postList.get(postId.intValue() - 1).toString());

        return postId + "번 게시물이 등록되었습니다!";
    }
}
