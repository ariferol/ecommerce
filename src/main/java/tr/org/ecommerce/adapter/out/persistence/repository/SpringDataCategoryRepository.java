package tr.org.ecommerce.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.org.ecommerce.adapter.out.persistence.entity.CategoryJpaEntity;
import tr.org.ecommerce.domain.model.common.ID;

import java.util.UUID;

@Repository
public interface SpringDataCategoryRepository extends JpaRepository<CategoryJpaEntity, ID> {
}

