package sopt.org.ThirdSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdSeminar.domain.Post;

public interface PostRepository extends Repository<Post,Long> {
    void save(Post post);
}
