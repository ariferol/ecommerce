package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.application.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public UUID handle(CreateProductCommandDto command) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(command.name());
        product.setDescription(command.description());
        product.setBasePrice(command.basePrice());
        product.setCurrentPrice(command.basePrice()); // varsayılan olarak
        product.setCategoryIds(command.categoryIds());
        product.setStockQuantity(command.stockQuantity());
        product.setStatus(Product.ProductStatus.ACTIVE);
        product.setWeight(command.weight());
        product.setHeight(command.height());
        product.setWidth(command.width());
        product.setDepth(command.depth());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRepositoryPort.save(product);
        return product.getId();
    }
}
