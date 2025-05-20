package tr.org.ecommerce.domain.model.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoryProductDto {

    @NotNull
    private UUID categoryId;

    @NotNull
    private UUID productId;
}
