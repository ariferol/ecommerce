package tr.org.ecommerce.domain.port.in;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.org.ecommerce.application.dto.CategoryDto;
import tr.org.ecommerce.application.dto.CategoryProductDto;
import tr.org.ecommerce.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRestAPI {
    
    ResponseEntity<String> createCategory(CategoryDto dto);
    
    ResponseEntity<List<Category>> listCategories();

    ResponseEntity<Category> updateCategory(UUID id, CategoryDto dto);

    ResponseEntity<Void> deleteCategory(UUID id);

    ResponseEntity<Void> addProductToCategory(UUID categoryId, UUID productId);

    ResponseEntity<Void> addProductToCategory(CategoryProductDto dto);
}
