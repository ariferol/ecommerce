package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.domain.port.CategoryRepositoryPort;

import java.util.UUID;

public class DeleteCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public DeleteCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    public void handle(UUID id) {
        categoryRepositoryPort.deleteById(id);
    }
}

