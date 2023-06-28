package sopt.org.fouthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fouthSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}
