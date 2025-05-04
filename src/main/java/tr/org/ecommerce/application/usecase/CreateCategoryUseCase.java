package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.application.dto.CategoryDto;
import tr.org.ecommerce.domain.model.Category;
import tr.org.ecommerce.domain.port.CategoryRepositoryPort;

import java.util.UUID;

public class CreateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public CreateCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    public UUID handle(CategoryDto dto) {
        Category category = new Category(
                UUID.randomUUID(),
                dto.name(),
                dto.description(),
                dto.parentCategoryId()
        );
        return categoryRepositoryPort.save(category).getId();
    }
}
