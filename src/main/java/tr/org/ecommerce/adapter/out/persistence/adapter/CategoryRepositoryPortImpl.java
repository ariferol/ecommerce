package tr.org.ecommerce.infrastructure.repository;

import org.springframework.stereotype.Repository;
import tr.org.ecommerce.domain.model.Category;
import tr.org.ecommerce.domain.port.CategoryRepositoryPort;
import tr.org.ecommerce.adapter.out.persistence.entity.CategoryJpaEntity;
import tr.org.ecommerce.adapter.out.persistence.repository.SpringDataCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryPortImpl implements CategoryRepositoryPort {

    private final SpringDataCategoryRepository jpa;

    public CategoryRepositoryPortImpl(SpringDataCategoryRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Category save(Category category) {
        CategoryJpaEntity entity = new CategoryJpaEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setParentCategoryId(category.getParentCategoryId());
        CategoryJpaEntity saved = jpa.save(entity);
        return new Category(saved.getId(), saved.getName(), saved.getDescription(), saved.getParentCategoryId());
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return jpa.findById(id).map(entity ->
                new Category(entity.getId(), entity.getName(), entity.getDescription(), entity.getParentCategoryId())
        );
    }

    @Override
    public List<Category> findAll() {
        return jpa.findAll().stream().map(entity ->
                new Category(entity.getId(), entity.getName(), entity.getDescription(), entity.getParentCategoryId())
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}

