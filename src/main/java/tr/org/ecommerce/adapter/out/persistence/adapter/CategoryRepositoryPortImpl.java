package tr.org.ecommerce.adapter.out.persistence.adapter;

import org.springframework.stereotype.Repository;
import tr.org.ecommerce.adapter.out.persistence.mapper.CategoryMapper;
import tr.org.ecommerce.adapter.out.persistence.mapper.ProductMapper;
import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.port.out.CategoryRepositoryPort;
import tr.org.ecommerce.adapter.out.persistence.entity.CategoryJpaEntity;
import tr.org.ecommerce.adapter.out.persistence.repository.SpringDataCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryPortImpl implements CategoryRepositoryPort {

    private final SpringDataCategoryRepository springDataRepo;

    public CategoryRepositoryPortImpl(SpringDataCategoryRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Category save(Category category) {
        CategoryJpaEntity saved = springDataRepo.save(CategoryMapper.mapToJpaEntity(category));
        CategoryMapper.mapToCategory(saved);
        return CategoryMapper.mapToCategory(saved);
    }

    @Override
    public Optional<Category> findById(ID id) {
        return springDataRepo.findById(id).map(CategoryMapper::mapToCategory);
    }

    @Override
    public List<Category> findAll() {
        return springDataRepo.findAll().stream().map(CategoryMapper::mapToCategory).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(ID categoryId) {
        return springDataRepo.existsById(categoryId);
    }

    @Override
    public void deleteById(ID id) {
        springDataRepo.deleteById(id);
    }
}

