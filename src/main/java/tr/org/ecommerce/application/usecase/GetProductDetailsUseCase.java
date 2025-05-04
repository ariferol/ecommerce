package tr.org.ecommerce.application.usecase;
import tr.org.ecommerce.application.dto.ProductDto;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;

import java.util.Optional;
import java.util.UUID;

public class GetProductDetailsUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public GetProductDetailsUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public ProductDto handle(UUID productId) {
        Optional<Product> product = productRepositoryPort.findById(productId);
        return product.map(this::toDto).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    private ProductDto toDto(Product p) {
        return new ProductDto(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getBasePrice(),
                p.getCurrentPrice(),
                p.getCategoryIds(),
                p.getStockQuantity(),
                p.getStatus(),
                p.getWeight(),
                p.getHeight(),
                p.getWidth(),
                p.getDepth(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }
}