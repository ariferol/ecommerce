package tr.org.ecommerce.infrastructure.repository;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.domain.model.Product;
import tr.org.ecommerce.domain.port.ProductRepositoryPort;
import tr.org.ecommerce.adapter.out.persistence.entity.ProductJpaEntity;
import tr.org.ecommerce.adapter.out.persistence.repository.SpringDataProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryPortImpl implements ProductRepositoryPort {

    private final SpringDataProductRepository springDataRepo;

    public ProductRepositoryPortImpl(SpringDataProductRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return springDataRepo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return springDataRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        springDataRepo.save(toEntity(product));
    }

    @Override
    public void deleteById(UUID id) {
        springDataRepo.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return springDataRepo.existsById(id);
    }

    private ProductJpaEntity toEntity(Product product) {
        ProductJpaEntity entity = new ProductJpaEntity();
        entity.setId(product.getId());
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
        return entity;
    }

    private Product toDomain(ProductJpaEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setBasePrice(entity.getBasePrice());
        product.setCurrentPrice(entity.getCurrentPrice());
        product.setStockQuantity(entity.getStockQuantity());
        product.setStatus(Product.ProductStatus.valueOf(entity.getStatus().name()));
        product.setWeight(entity.getWeight());
        product.setHeight(entity.getHeight());
        product.setWidth(entity.getWidth());
        product.setDepth(entity.getDepth());
        product.setCreatedAt(entity.getCreatedAt());
        product.setUpdatedAt(entity.getUpdatedAt());
        return product;
    }
}
