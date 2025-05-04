package tr.org.ecommerce.adapter.in.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.org.ecommerce.application.dto.CategoryDto;
import tr.org.ecommerce.application.dto.CategoryProductDto;
import tr.org.ecommerce.application.usecase.CreateCategoryUseCase;
import tr.org.ecommerce.application.usecase.DeleteCategoryUseCase;
import tr.org.ecommerce.application.usecase.ListCategoriesUseCase;
import tr.org.ecommerce.application.usecase.UpdateCategoryUseCase;
import tr.org.ecommerce.domain.model.Category;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.CategoryRepositoryPort;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;
import tr.org.ecommerce.infrastructure.repository.entity.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final ListCategoriesUseCase listCategoriesUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase, ListCategoriesUseCase listCategoriesUseCase, UpdateCategoryUseCase updateCategoryUseCase, DeleteCategoryUseCase deleteCategoryUseCase, CategoryRepositoryPort categoryRepositoryPort, ProductRepositoryPort productRepositoryPort) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.listCategoriesUseCase = listCategoriesUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto dto) {
        UUID categoryId = createCategoryUseCase.handle(dto);
        return ResponseEntity.status(201).body(categoryId.toString());
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> categories = listCategoriesUseCase.handle();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody CategoryDto dto) {
        Category updatedCategory = updateCategoryUseCase.handle(id, dto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        deleteCategoryUseCase.handle(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Void> addProductToCategory(@PathVariable UUID categoryId, @PathVariable UUID productId) {
        var categoryOpt = categoryRepositoryPort.findById(categoryId);
        var productOpt = productRepositoryPort.findById(productId);

        if (categoryOpt.isEmpty() || productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var category = categoryOpt.get();
        var product = productOpt.get();

        category.getProducts().add(product);
        product.getCategories().add(category);

        categoryRepositoryPort.save(category);
        productRepositoryPort.save(product);

        return ResponseEntity.noContent().build();
    }

   @PostMapping("/products")
    public ResponseEntity<Void> addProductToCategory(@Valid @RequestBody CategoryProductDto dto) {
        Optional<Category> categoryOpt = categoryRepositoryPort.findById(dto.getCategoryId());
        Optional<Product> productOpt = productRepositoryPort.findById(dto.getProductId());

        if (categoryOpt.isEmpty() || productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Category category = categoryOpt.get();
        Product product = productOpt.get();

        category.getProducts().add(product);
        product.getCategories().add(category);

        categoryRepositoryPort.save(category);
        productRepositoryPort.save(product);

        return ResponseEntity.noContent().build();
    }
}
