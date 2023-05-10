package sopt.org.fouthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fouthSeminar.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    // CREATE
    void save(User user);

    // READ
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    // UPDATE

    // DELETE
}
