package sopt.org.fouthSeminar.infrastructure;

import org.springframework.data.repository.CrudRepository;
import sopt.org.fouthSeminar.domain.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}