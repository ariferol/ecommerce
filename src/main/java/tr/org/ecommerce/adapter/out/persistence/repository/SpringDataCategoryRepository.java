package tr.org.ecommerce.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.org.ecommerce.adapter.out.persistence.CategoryJpaEntity;

import java.util.UUID;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryJpaEntity, UUID> {
}

