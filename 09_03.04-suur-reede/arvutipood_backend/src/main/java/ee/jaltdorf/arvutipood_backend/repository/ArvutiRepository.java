package ee.jaltdorf.arvutipood_backend.repository;

import ee.jaltdorf.arvutipood_backend.entity.Arvuti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArvutiRepository extends JpaRepository<Arvuti, Long> {
}
