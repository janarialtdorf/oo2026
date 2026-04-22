package ee.jaltdorf.decathlon.repository;

import ee.jaltdorf.decathlon.entity.Sport;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<@NonNull Sport,@NonNull Long> {
}
