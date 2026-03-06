package ee.jaltdorf.proovikontrolltoo1.repository;

import ee.jaltdorf.proovikontrolltoo1.entity.Genre;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<@NonNull Genre,@NonNull Long> {
}
