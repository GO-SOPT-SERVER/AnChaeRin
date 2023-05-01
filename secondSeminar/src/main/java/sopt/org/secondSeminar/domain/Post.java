package sopt.org.secondSeminar.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Post {

    private Long id;

    private String title;

    private String content;


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
