package tr.org.ecommerce.domain.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Category {

    private UUID id;
    private String name;
    private String description;
    private UUID parentCategoryId;
    private List<Product> products;

    public Category(UUID id, String name, String description, UUID parentCategoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentCategoryId = parentCategoryId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getParentCategoryId() {
        return parentCategoryId;
    }
}
