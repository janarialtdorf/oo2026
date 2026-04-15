package ee.jaltdorf.decathlon.repository;

import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.entity.Result;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AthleteRepository extends JpaRepository<@NonNull Athlete,@NonNull Long> {
    Page<Athlete> findByCountry(String country, Pageable pageable);
}
