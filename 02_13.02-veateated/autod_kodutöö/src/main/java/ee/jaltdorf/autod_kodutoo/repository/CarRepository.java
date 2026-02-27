package ee.jaltdorf.autod_kodutoo.repository;

import ee.jaltdorf.autod_kodutoo.entity.Car;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<@NonNull Car,@NonNull Long> {

    Car findByModel(String model);
}
