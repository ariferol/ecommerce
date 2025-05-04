package tr.org.ecommerce.application.usecase;

import tr.org.ecommerce.application.dto.ProductDto;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class ListProductsUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public ListProductsUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public List<ProductDto> handle() {
        return productRepositoryPort.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
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
