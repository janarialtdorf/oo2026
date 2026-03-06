package ee.jaltdorf.KT1_Kiirus.repository;

import ee.jaltdorf.KT1_Kiirus.entity.Velocity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VelocityRepository extends JpaRepository<@NonNull Velocity,@NonNull Long> {
}
