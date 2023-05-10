package sopt.org.fouthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fouthSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ

    // UPDATE

    // DELETE
}
