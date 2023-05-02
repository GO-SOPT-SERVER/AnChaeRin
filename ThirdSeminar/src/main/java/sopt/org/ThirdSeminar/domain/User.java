package sopt.org.ThirdSeminar.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name="USER_ID")
    private List<Post> posts=new ArrayList<>();

    @Builder
    public User(String nickname, String email, String password){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
    }



}
