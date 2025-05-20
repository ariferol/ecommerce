package tr.org.ecommerce.domain.port.in.rest;

import org.springframework.http.ResponseEntity;
import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.category.dto.CategoryProductDto;
import tr.org.ecommerce.domain.model.category.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRestAPI {
    
    ResponseEntity<CategoryDto> registerCategory(CategoryDto dto);
    
    ResponseEntity<List<CategoryDto>> listCategories();

    ResponseEntity<CategoryDto> updateCategory(String id, CategoryDto dto);

    ResponseEntity<Void> deleteCategory(String id);

    ResponseEntity<Void> addProductToCategory(String categoryId, String productId);

}
