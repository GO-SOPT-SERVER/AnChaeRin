package sopt.org.ThirdSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdSeminar.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);

    Optional<User> findById(Long id);
}
