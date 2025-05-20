package tr.org.ecommerce.application.service.spec;

import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.common.ID;

import java.util.List;

public interface CategoryAppService {
    Category create(CategoryDto categoryDto);

    List<Category> listCategories();

    Category updateCategory(ID categoryId, CategoryDto dto);

    boolean deleteCategory(ID categoryId);

    boolean addProductToCategory(ID categoryId, ID productId);
}
