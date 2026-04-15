package ee.jaltdorf.decathlon.repository;

import ee.jaltdorf.decathlon.entity.Result;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultRepository extends JpaRepository<@NonNull Result,@NonNull Long> {
}
