package tr.org.ecommerce.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.org.ecommerce.adapter.out.persistence.mapper.ProductMapper;
import tr.org.ecommerce.application.service.spec.ProductAppService;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;
import tr.org.ecommerce.domain.port.in.rest.ProductRestAPI;

import java.net.URI;
import java.util.List;


/**
 * Web Adapter Layer da ; Security validations(sanitize işlemleri,authentication, authorization,,...)
 * http request validations işlemleri yapılır
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductRestAPI {

    @Autowired
    private ProductAppService productAppService;

    @PostMapping
    @Override
    public ResponseEntity<ProductDto> registerProduct(@RequestBody CreateProductCommandDto createProductCommandDto) {
        Product product = productAppService.create(createProductCommandDto);
        URI location = URI.create("/products/" + product.getId().id());
        return ResponseEntity.created(location)
                .body(ProductMapper.mapToProductDto(product));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts(
    ) {
        /**
         * SORU: Map leme burada mı olmalı? Yoksa Application layer da mı olmalı? Yada hiç bir business logic yoksa,
         * persistence layer ın out portunda db den veriyi çekerken jpa entity listesini doğrudan dto ya mı çevirmeliyim?
         * */
        List<Product> products = productAppService.getAllProducts();
        return ResponseEntity.ok(ProductMapper.mapToDtoList(products));
    }

    @GetMapping("/pageable")
    @Override
    @Operation(
            summary = "Sayfalı Ürün Listesi",
            description = "Sayfalı şekilde ürün listesini getirir. Örnek: `/pageable?page=0&size=10&sort=name,desc`"
    )
    public ResponseEntity<Page<ProductDto>> getAllProductsWithPageable(
            @ParameterObject
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        Page<Product> productPage = productAppService.getAllProductsWithPageable(pageable);
        Page<ProductDto> pageableProduct = ProductMapper.mapToProductDtoPage(productPage);
        return ResponseEntity.ok(pageableProduct);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProductDto> getProductDetails(@PathVariable("id") String productId) {
        Product product = productAppService.getProductDetails(ID.of(productId));
        return ResponseEntity.ok(ProductMapper.mapToProductDto(product));
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") String productId, @Valid @RequestBody ProductDto dto) {
        Product updated = productAppService.updateProduct(ID.of(productId), dto);
        return ResponseEntity.ok(ProductMapper.mapToProductDto(updated));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String productId) {
        boolean deleted = productAppService.deleteProduct(ID.of(productId));
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
