package tr.org.ecommerce.application.dto;

import java.math.BigDecimal;
import java.util.List;

public record CreateProductCommandDto(
        String name,
        String description,
        BigDecimal basePrice,
        List<java.util.UUID> categoryIds,
        int stockQuantity,
        double weight,
        double height,
        double width,
        double depth
) {}

