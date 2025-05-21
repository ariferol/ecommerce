package tr.org.ecommerce.application.service.spec;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;

import java.util.List;

public interface ProductAppService {

    Product create(CreateProductCommandDto createProductCommandDto);

    List<Product> getAllProducts();

    Product getProductDetails(ID productId);

    Product updateProduct(ID productId, ProductDto dto);

    boolean deleteProduct(ID productId);

    Page<Product> getAllProductsWithPageable(Pageable pageable);
}
