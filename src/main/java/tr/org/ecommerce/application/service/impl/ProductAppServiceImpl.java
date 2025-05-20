package tr.org.ecommerce.application.service.impl;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.application.service.spec.LogAppService;
import tr.org.ecommerce.application.service.spec.ProductAppService;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;
import tr.org.ecommerce.domain.port.out.ProductRepositoryPort;

import java.util.List;

/**
 * Application Layer da ; Logging işlemleri, harici dış servislere gidip gelme,
 * CRUD işlemler için doğrudan repository ye gidiş, yada
 * business logic ler için Domain Layer daki domain servislere(Usecase lere) gidip gelme işlemleri yapılır
 */
@Component
public class ProductAppServiceImpl implements ProductAppService {

    private final ProductRepositoryPort productRepositoryPort;
    private final LogAppService logAppService;

    public ProductAppServiceImpl(ProductRepositoryPort productRepositoryPort, LogAppService logAppService) {
        this.productRepositoryPort = productRepositoryPort;
        this.logAppService = logAppService;
    }

    @Override
    public Product create(CreateProductCommandDto createProductCommandDto) {
        System.out.println("***** Creating product name = " + createProductCommandDto.name());
        Product product = productRepositoryPort.save(Product.of(createProductCommandDto));
        System.out.println("Created product Id : " + product.getId().id());
        logAppService.log("Created product Id : " + product.getId().id());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepositoryPort.findAll();
        System.out.println("Product list size : " + productList.size());
        logAppService.log("Product list size : " + productList.size());
        return productList;
    }

    @Override
    public Product getProductDetails(ID productId) {
        Product product = productRepositoryPort.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        System.out.println("getProductDetails, product Id : " + product.getId().id());
        logAppService.log("getProductDetails, product Id : " + product.getId().id());
        return product;
    }

    @Override
    public Product updateProduct(ID productId, ProductDto dto) {
        Product product = productRepositoryPort.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        // Güncellemeleri uygula
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setBasePrice(dto.basePrice());
        product.setCurrentPrice(dto.currentPrice());
        product.setCategoryIds(dto.categoryIds());
        product.setStockQuantity(dto.stockQuantity());
        product.setStatus(dto.status());
        product.setWeight(dto.weight());
        product.setHeight(dto.height());
        product.setWidth(dto.width());
        product.setDepth(dto.depth());
        product.setUpdatedAt(dto.updatedAt());
        return productRepositoryPort.save(product);
    }

    @Override
    public boolean deleteProduct(ID productId){
        if (!productRepositoryPort.existsById(productId)) {
            return false;
        }
        productRepositoryPort.deleteById(productId);
        return true;
    }
}
