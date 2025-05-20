package tr.org.ecommerce.application.dto;

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
