package tr.org.ecommerce.domain.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Product save(Product product);

    Optional<Product> findById(ID id);

    List<Product> findAll();

    void deleteById(ID id);

    boolean existsById(ID id);

    Page<Product> findAll(Pageable pageable);
}
