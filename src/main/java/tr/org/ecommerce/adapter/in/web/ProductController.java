package tr.org.ecommerce.adapter.in.web;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.org.ecommerce.application.dto.CreateProductCommandDto;
import tr.org.ecommerce.application.dto.ProductDto;
import tr.org.ecommerce.application.usecase.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final GetProductDetailsUseCase getProductDetailsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase, GetProductDetailsUseCase getProductDetailsUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.getProductDetailsUseCase = getProductDetailsUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @PostMapping
    public ResponseEntity<UUID> createProduct(@RequestBody CreateProductCommandDto command) {
        UUID productId = createProductUseCase.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(listProductsUseCase.handle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductDetails(@PathVariable UUID id) {
        ProductDto product = getProductDetailsUseCase.handle(id);
        return ResponseEntity.ok(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable UUID id, @RequestBody ProductDto dto) {
        updateProductUseCase.handle(id, dto);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        deleteProductUseCase.handle(id);
        return ResponseEntity.noContent().build();
    }
}
