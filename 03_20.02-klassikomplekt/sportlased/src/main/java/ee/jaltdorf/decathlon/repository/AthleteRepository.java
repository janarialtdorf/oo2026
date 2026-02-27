package ee.jaltdorf.decathlon.repository;

import ee.jaltdorf.decathlon.entity.Athlete;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<@NonNull Athlete,@NonNull Long> {
}
