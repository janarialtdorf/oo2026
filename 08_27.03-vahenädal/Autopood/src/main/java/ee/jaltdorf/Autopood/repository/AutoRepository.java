package ee.jaltdorf.Autopood.repository;

import ee.jaltdorf.Autopood.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Long> {
}
