package tr.org.ecommerce.domain.model.product.dto;

import jakarta.validation.constraints.*;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.common.ID;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ProductDto(
        @NotNull(message = "ID cannot be null")
        String id,

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be at most 100 characters")
        String name,

        @Size(max = 1000, message = "Description can be at most 1000 characters")
        String description,

        @NotNull(message = "Base price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Base price must be greater than 0")
        BigDecimal basePrice,

        @NotNull(message = "Current price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Current price must be greater than 0")
        BigDecimal currentPrice,

        @NotNull(message = "Category list cannot be null")
        @Size(min = 1, message = "At least one category must be provided")
        List<UUID> categoryIds,

        @Min(value = 0, message = "Stock quantity cannot be negative")
        int stockQuantity,

        @NotNull(message = "Product status is required")
        Product.ProductStatus status,

        @DecimalMin(value = "0.0", inclusive = true, message = "Weight must be non-negative")
        double weight,

        @DecimalMin(value = "0.0", inclusive = true, message = "Height must be non-negative")
        double height,

        @DecimalMin(value = "0.0", inclusive = true, message = "Width must be non-negative")
        double width,

        @DecimalMin(value = "0.0", inclusive = true, message = "Depth must be non-negative")
        double depth,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {}

