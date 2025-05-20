package tr.org.ecommerce.application.dto;

import tr.org.ecommerce.domain.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        String description,
        BigDecimal basePrice,
        BigDecimal currentPrice,
        List<UUID> categoryIds,
        int stockQuantity,
        Product.ProductStatus status,
        double weight,
        double height,
        double width,
        double depth,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

