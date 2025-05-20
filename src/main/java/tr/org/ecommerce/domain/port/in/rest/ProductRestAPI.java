package tr.org.ecommerce.domain.port.in;

import org.springframework.http.ResponseEntity;
import tr.org.ecommerce.application.dto.CreateProductCommandDto;
import tr.org.ecommerce.application.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductRestAPI {

    ResponseEntity<UUID> createProduct(CreateProductCommandDto command);

    ResponseEntity<List<ProductDto>> getAllProducts();

    ResponseEntity<ProductDto> getProductDetails(UUID id);

    ResponseEntity<Void> updateProduct(UUID id, ProductDto dto);

    ResponseEntity<Void> deleteProduct(UUID id);

}
