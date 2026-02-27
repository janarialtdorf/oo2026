package ee.jaltdorf.veebipood.repository;

import ee.jaltdorf.veebipood.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//repository -> andmebaasiga suhtlemiseks
public interface ProductRepository extends JpaRepository<Product,Long>{
    Long id(Long id);
}
