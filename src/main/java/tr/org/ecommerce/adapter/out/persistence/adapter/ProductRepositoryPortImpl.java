package tr.org.ecommerce.adapter.out.persistence.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tr.org.ecommerce.adapter.out.persistence.mapper.ProductMapper;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.port.out.ProductRepositoryPort;
import tr.org.ecommerce.adapter.out.persistence.entity.ProductJpaEntity;
import tr.org.ecommerce.adapter.out.persistence.repository.SpringDataProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Persistence Adapter Layer da ; Veri tabanına gidip gelme işlemleri yapılır.
 * Biz burada spring data api sini kullanarak bu işlemi gerçekleştirdik.
 */

@Component
public class ProductRepositoryPortImpl implements ProductRepositoryPort {

    private final SpringDataProductRepository springDataRepo;

    public ProductRepositoryPortImpl(SpringDataProductRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Product save(Product product) {
        ProductJpaEntity result = springDataRepo.save(ProductMapper.mapToJpaEntity(product));
        return ProductMapper.mapToProduct(result);
    }

    @Override
    public Optional<Product> findById(ID id) {
        return springDataRepo.findById(id).map(ProductMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return springDataRepo.findAll().stream().map(ProductMapper::mapToProduct).collect(Collectors.toList());
    }

    @Override
    public void deleteById(ID id) {
        springDataRepo.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return springDataRepo.existsById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<ProductJpaEntity> result = springDataRepo.findAll(pageable);
        Page<Product> pageableProduct = ProductMapper.mapToProductPage(result);
        return pageableProduct;
    }

}
