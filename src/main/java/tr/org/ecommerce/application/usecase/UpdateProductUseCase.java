package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.application.dto.ProductDto;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;

import java.util.UUID;

public class UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public void handle(UUID productId, ProductDto dto) {
        Product product = productRepositoryPort.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Güncellemeleri uygula
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setBasePrice(dto.basePrice());
        product.setCurrentPrice(dto.currentPrice());
        product.setCategoryIds(dto.categoryIds());
        product.setStockQuantity(dto.stockQuantity());
        product.setStatus(dto.status());
        product.setWeight(dto.weight());
        product.setHeight(dto.height());
        product.setWidth(dto.width());
        product.setDepth(dto.depth());
        product.setUpdatedAt(dto.updatedAt());

        productRepositoryPort.save(product);
    }
}
