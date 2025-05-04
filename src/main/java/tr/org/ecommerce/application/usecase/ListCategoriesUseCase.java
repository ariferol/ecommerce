package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.domain.model.Category;
import tr.org.ecommerce.domain.port.CategoryRepositoryPort;

import java.util.List;

public class ListCategoriesUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public ListCategoriesUseCase(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    public List<Category> handle() {
        return categoryRepositoryPort.findAll();
    }
}

