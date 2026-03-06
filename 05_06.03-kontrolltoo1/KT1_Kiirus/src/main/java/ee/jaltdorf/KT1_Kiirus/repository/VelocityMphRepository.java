package ee.jaltdorf.KT1_Kiirus.repository;

import ee.jaltdorf.KT1_Kiirus.entity.VelocityMph;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VelocityMphRepository extends JpaRepository< @NonNull VelocityMph, @NonNull Long> {
}
