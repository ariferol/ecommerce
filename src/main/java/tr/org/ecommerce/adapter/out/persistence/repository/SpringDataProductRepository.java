package tr.org.ecommerce.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.org.ecommerce.adapter.out.persistence.ProductEntity;

import java.util.UUID;

@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, UUID> {
}

