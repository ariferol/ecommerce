package tr.org.ecommerce.application.service.impl;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.application.service.spec.CategoryAppService;
import tr.org.ecommerce.application.service.spec.LogAppService;
import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.port.out.CategoryRepositoryPort;
import tr.org.ecommerce.domain.usecase.CategoryUseCases;

import java.util.List;

@Component
public class CategoryAppServiceImpl implements CategoryAppService {
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final LogAppService logAppService;
    private final CategoryUseCases categoryUseCases;

    public CategoryAppServiceImpl(CategoryRepositoryPort categoryRepositoryPort,
                                  LogAppService logAppService,
                                  CategoryUseCases categoryUseCases) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.logAppService = logAppService;
        this.categoryUseCases = categoryUseCases;
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        System.out.println("***** Creating category name = " + categoryDto.name());
        Category category = categoryRepositoryPort.save(Category.of(categoryDto));
        System.out.println("Created product Id : " + category.getId().id());
        logAppService.log("Created category Id : " + category.getId().id());
        return category;
    }

    @Override
    public List<Category> listCategories() {
        List<Category> categories = categoryRepositoryPort.findAll();
        System.out.println("Category list size : " + categories.size());
        logAppService.log("Category list size : " + categories.size());
        return categories;
    }

    @Override
    public Category updateCategory(ID categoryId, CategoryDto dto) {
        Category category = categoryRepositoryPort.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        // Güncellemeleri uygula
        category.setName(category.getName());
        category.setDescription(category.getDescription());
        category.setParentCategoryId(category.getParentCategoryId());
        return categoryRepositoryPort.save(category);
    }

    @Override
    public boolean deleteCategory(ID categoryId) {
        if (!categoryRepositoryPort.existsById(categoryId)) {
            return false;
        }
        categoryRepositoryPort.deleteById(categoryId);
        return true;
    }

    @Override
    public boolean addProductToCategory(ID categoryId, ID productId) {
        /*Ürünü , kategoriye ekler*/
        boolean result = categoryUseCases.addProductToCategory(categoryId, productId);
        System.out.println("Product of categoryId: " + categoryId.id());
        logAppService.log("Added productId : " + productId.id());
        return result;
    }

}
