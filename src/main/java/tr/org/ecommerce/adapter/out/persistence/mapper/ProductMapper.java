package tr.org.ecommerce.adapter.out.persistence.mapper;

import org.springframework.data.domain.Page;
import tr.org.ecommerce.adapter.out.persistence.entity.ProductJpaEntity;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductJpaEntity mapToJpaEntity(Product product) {
        ProductJpaEntity entity = new ProductJpaEntity();
        entity.setId(product.getId().id());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setBasePrice(product.getBasePrice());
        entity.setCurrentPrice(product.getCurrentPrice());
        entity.setStockQuantity(product.getStockQuantity());
        entity.setStatus(ProductJpaEntity.ProductStatus.valueOf(product.getStatus().name()));
        entity.setWeight(product.getWeight());
        entity.setHeight(product.getHeight());
        entity.setWidth(product.getWidth());
        entity.setDepth(product.getDepth());
        entity.setCreatedAt(product.getCreatedAt());
        entity.setUpdatedAt(product.getUpdatedAt());
        entity.setCategories(CategoryMapper.mapToJpaEntityList(product.getCategories()));
        return entity;
    }

    public static Product mapToProduct(ProductJpaEntity jpaEntity) {
        Product product = new Product(ID.of(jpaEntity.getId()));
        //product.setId(ID.of(jpaEntity.getId()));
        product.setName(jpaEntity.getName());
        product.setDescription(jpaEntity.getDescription());
        product.setBasePrice(jpaEntity.getBasePrice());
        product.setCurrentPrice(jpaEntity.getCurrentPrice());
        product.setStockQuantity(jpaEntity.getStockQuantity());
        product.setStatus(Product.ProductStatus.valueOf(jpaEntity.getStatus().name()));
        product.setWeight(jpaEntity.getWeight());
        product.setHeight(jpaEntity.getHeight());
        product.setWidth(jpaEntity.getWidth());
        product.setDepth(jpaEntity.getDepth());
        product.setCreatedAt(jpaEntity.getCreatedAt());
        product.setUpdatedAt(jpaEntity.getUpdatedAt());
        return product;
    }

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getId().id(),
                product.getName(),
                product.getDescription(),
                product.getBasePrice(),
                product.getCurrentPrice(),
                product.getCategoryIds(),
                product.getStockQuantity(),
                product.getStatus(),
                product.getWeight(),
                product.getHeight(),
                product.getWidth(),
                product.getDepth(),
                product.getCreatedAt(),
                product.getUpdatedAt());
    }

    public static List<ProductDto> mapToDtoList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .toList();
    }

    public static List<ProductJpaEntity> mapToJpaEntityList(List<Product> products) {
        if (products != null && !products.isEmpty())
            return products.stream()
                    .map(ProductMapper::mapToJpaEntity)
                    .toList();
        else
            return new ArrayList<>();
    }

    public static Page<Product> mapToProductPage(Page<ProductJpaEntity> entityPage) {
        return entityPage.map(ProductMapper::mapToProduct);
    }

    public static Page<ProductDto> mapToProductDtoPage(Page<Product> productPage) {
        return productPage.map(ProductMapper::mapToProductDto);
    }
}
