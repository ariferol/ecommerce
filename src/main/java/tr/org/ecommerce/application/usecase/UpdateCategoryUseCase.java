package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.application.dto.CategoryDto;
import tr.org.ecommerce.domain.model.Category;
import tr.org.ecommerce.domain.port.CategoryRepositoryPort;

import java.util.UUID;

public class UpdateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public UpdateCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    public Category handle(UUID id, CategoryDto dto) {
        Category category = categoryRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.name());
        category.setDescription(dto.description());
        category.setParentCategoryId(dto.parentCategoryId());

        return categoryRepositoryPort.save(category);
    }
}

