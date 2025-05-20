package tr.org.ecommerce.domain.port.out;

import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.common.ID;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(ID id);
    List<Category> findAll();
    boolean existsById(ID categoryId);
    void deleteById(ID id);

}