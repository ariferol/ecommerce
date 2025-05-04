package tr.org.ecommerce.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal basePrice;
    private BigDecimal currentPrice;
    private List<UUID> categoryIds;
    private int stockQuantity;
    private ProductStatus status;
    private double weight;
    private double height;
    private double width;
    private double depth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Category> categories;

    public enum ProductStatus {
        ACTIVE,
        DISCONTINUED,
        OUT_OF_STOCK
    }

    // Constructor, getters, setters (ya da lombok kullanabiliriz)
}
