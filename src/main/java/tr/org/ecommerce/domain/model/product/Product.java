package tr.org.ecommerce.domain.model.product;

import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.common.AbstractEntity;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Product extends AbstractEntity {

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

    public Product(ID id) {
        super(id);
    }

    public static Product of(CreateProductCommandDto createProductCommandDto) {
        Product product = new Product(ID.create());
        product.setName(createProductCommandDto.name());
        product.setDescription(createProductCommandDto.description());
        product.setBasePrice(createProductCommandDto.basePrice());
        product.setCurrentPrice(createProductCommandDto.basePrice()); // varsayılan olarak
        product.setCategoryIds(createProductCommandDto.categoryIds());
        product.setStockQuantity(createProductCommandDto.stockQuantity());
        product.setStatus(Product.ProductStatus.ACTIVE);
        product.setWeight(createProductCommandDto.weight());
        product.setHeight(createProductCommandDto.height());
        product.setWidth(createProductCommandDto.width());
        product.setDepth(createProductCommandDto.depth());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }

    public enum ProductStatus {
        ACTIVE,
        DISCONTINUED,
        OUT_OF_STOCK
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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public List<UUID> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<UUID> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean isBlackList() {
        return BlacklistedProduct.isBlacklisted(getName()) ;
    }

    private enum BlacklistedProduct {
        DINAMIT("Dinamit"),
        EROIN("Eroin"),
        ESRAR("Esrar"),
        KOKAIN("Kokain");

        private final String productName;

        BlacklistedProduct(String productName) {
            this.productName = productName;
        }

        public String getProductName() {
            return productName;
        }

        public static boolean isBlacklisted(String name) {
            for (BlacklistedProduct item : BlacklistedProduct.values()) {
                if (item.getProductName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
            return false;
        }
    }
}
