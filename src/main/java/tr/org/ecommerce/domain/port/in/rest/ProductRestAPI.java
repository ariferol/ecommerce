package tr.org.ecommerce.domain.port.in.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;

import java.util.List;

public interface ProductRestAPI {

    ResponseEntity<ProductDto> registerProduct(CreateProductCommandDto command);

    ResponseEntity<List<ProductDto>> getAllProducts();

    ResponseEntity<Page<ProductDto>> getAllProductsWithPageable(Pageable pageable);

    ResponseEntity<ProductDto> getProductDetails(String id);

    ResponseEntity<ProductDto> updateProduct(String id, ProductDto dto);

    ResponseEntity<Void> deleteProduct(String id);

}
