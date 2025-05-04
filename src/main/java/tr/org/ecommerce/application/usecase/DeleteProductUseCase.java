package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.domain.port.ProductRepositoryPort;

import java.util.UUID;

public class DeleteProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public void handle(UUID productId) {
        if (!productRepositoryPort.existsById(productId)) {
            throw new RuntimeException("Product not found");
        }
        productRepositoryPort.deleteById(productId);
    }
}

