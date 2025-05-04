package tr.org.ecommerce.domain.port;

import tr.org.ecommerce.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    void save(Product product);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
