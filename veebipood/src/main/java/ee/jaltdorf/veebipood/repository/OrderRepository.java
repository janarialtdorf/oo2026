package ee.jaltdorf.veebipood.repository;

import ee.jaltdorf.veebipood.entity.Order;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<@NonNull Order,@NonNull Long> {
}
