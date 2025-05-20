package tr.org.ecommerce.adapter.out.persistence.mapper;

import tr.org.ecommerce.adapter.out.persistence.entity.CategoryJpaEntity;
import tr.org.ecommerce.adapter.out.persistence.entity.ProductJpaEntity;
import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId().id(),
                category.getName(),
                category.getDescription(),
                category.getParentCategoryId()
        );
    }

    public static CategoryJpaEntity mapToJpaEntity(Category category) {
        CategoryJpaEntity entity = new CategoryJpaEntity();
        entity.setId(category.getId().id());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setParentCategoryId(category.getParentCategoryId());
        entity.setProducts(ProductMapper.mapToJpaEntityList(category.getProducts()));
        return entity;

    }

    public static Category mapToCategory(CategoryJpaEntity jpaEntity) {
        Category category = new Category(ID.of(jpaEntity.getId()));
        category.setName(jpaEntity.getName());
        category.setDescription(jpaEntity.getDescription());
        category.setParentCategoryId(jpaEntity.getParentCategoryId());
        return category;
    }

    public static List<CategoryDto> mapToDtoList(List<Category> products) {
        return products.stream()
                .map(CategoryMapper::mapToCategoryDto)
                .toList();
    }

    public static List<CategoryJpaEntity> mapToJpaEntityList(List<Category> categories) {
        if (categories != null && !categories.isEmpty())
            return categories.stream()
                    .map(CategoryMapper::mapToJpaEntity)
                    .toList();
        else
            return new ArrayList<>();
    }
}
