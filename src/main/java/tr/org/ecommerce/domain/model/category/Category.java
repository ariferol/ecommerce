package tr.org.ecommerce.domain.model.category;

import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.common.AbstractEntity;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Category extends AbstractEntity {

    private String name;
    private String description;
    private UUID parentCategoryId;
    private List<Product> products;

    public Category(ID id) {
        super(id);
    }

    public Category(ID id, String name, String description, UUID uuid) {
        super(id);
        this.name = name;
        this.description = description;
        this.parentCategoryId = uuid;
        this.products = new ArrayList<>();
    }

    public static Category of(CategoryDto categoryDto) {
        Category category = new Category(
                ID.create(),
                categoryDto.name(),
                categoryDto.description(),
                categoryDto.parentCategoryId()
        );
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(UUID parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
