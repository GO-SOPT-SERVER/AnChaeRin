package sopt.org.ThirdSeminar.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.ThirdSeminar.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {


//    void save(Post post);
}
