package tr.org.ecommerce.domain.port.in.rest;

import org.springframework.http.ResponseEntity;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductRestAPI {

    ResponseEntity<ProductDto> registerProduct(CreateProductCommandDto command);

    ResponseEntity<List<ProductDto>> getAllProducts();

    ResponseEntity<ProductDto> getProductDetails(String id);

    ResponseEntity<ProductDto> updateProduct(String id, ProductDto dto);

    ResponseEntity<Void> deleteProduct(String id);

}
