package tr.org.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private double weight;
    private double height;
    private double width;
    private double depth;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "category_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    public enum ProductStatus {
        ACTIVE,
        DISCONTINUED,
        OUT_OF_STOCK
    }

}
