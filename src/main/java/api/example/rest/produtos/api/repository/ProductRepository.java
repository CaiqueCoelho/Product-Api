package api.example.rest.produtos.api.repository;

import api.example.rest.produtos.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
}
