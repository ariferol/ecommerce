package tr.org.ecommerce.application.dto;

import java.util.UUID;

public record CategoryDto(
        UUID id,
        String name,
        String description,
        UUID parentCategoryId
) {}

