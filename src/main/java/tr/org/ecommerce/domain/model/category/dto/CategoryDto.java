package tr.org.ecommerce.domain.model.category.dto;

import tr.org.ecommerce.domain.model.common.ID;

import java.util.UUID;

public record CategoryDto(
        String id,
        String name,
        String description,
        UUID parentCategoryId
) {}

