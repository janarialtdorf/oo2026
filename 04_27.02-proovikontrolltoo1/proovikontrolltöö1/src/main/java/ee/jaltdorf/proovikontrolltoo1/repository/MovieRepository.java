package ee.jaltdorf.proovikontrolltoo1.repository;

import ee.jaltdorf.proovikontrolltoo1.entity.Movie;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<@NonNull Movie,@NonNull Long> {
}
