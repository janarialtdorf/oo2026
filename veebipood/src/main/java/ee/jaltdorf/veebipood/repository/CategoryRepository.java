package ee.jaltdorf.veebipood.repository;

import ee.jaltdorf.veebipood.entity.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<@NonNull Category,@NonNull Long> {
}
