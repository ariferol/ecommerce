package tr.org.ecommerce.domain.model.category.service;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.model.product.Product;
import tr.org.ecommerce.domain.model.product.service.ProductPolicyUseCasesImpl;
import tr.org.ecommerce.domain.port.out.CategoryRepositoryPort;
import tr.org.ecommerce.domain.port.out.ProductRepositoryPort;
import tr.org.ecommerce.domain.usecase.CategoryPolicyUseCases;
import tr.org.ecommerce.domain.usecase.CategoryUseCases;
import tr.org.ecommerce.domain.usecase.ProductPolicyUseCases;

import java.util.Optional;

/**
 * Category domainine ait olan usecase lerin business logicleri ni .burada yazıyoruz(Domain services)
 */

@Component
public class CategoryUseCasesImpl implements CategoryUseCases {
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final ProductPolicyUseCases productPolicyUseCases;
    private final CategoryPolicyUseCases categoryPolicyUseCases;

    public CategoryUseCasesImpl(CategoryRepositoryPort categoryRepositoryPort,
                                ProductRepositoryPort productRepositoryPort,
                                ProductPolicyUseCases productPolicyUseCases,
                                CategoryPolicyUseCases categoryPolicyUseCases) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
        this.productPolicyUseCases = productPolicyUseCases;
        this.categoryPolicyUseCases = categoryPolicyUseCases;
    }

    @Override
    public boolean addProductToCategory(ID categoryId, ID productId) {
        Optional<Category> categoryOptional = categoryRepositoryPort.findById(categoryId);
        Optional<Product> productOptional = productRepositoryPort.findById(productId);

        if (categoryOptional.isEmpty() || productOptional.isEmpty()) {
            return false;
        }

        Category category = categoryOptional.get();
        Product product = productOptional.get();

        /**
         * Örnek olması için,
         * Product ve Category domain servis lerinden kategori ve ürünün yasaklı kategori ve ürün listesinde
         * olup olmadığını kontrol ediyoruz. Yasaklı listedey se kayda izin vermiyoruz;
         * */
        if (productPolicyUseCases.isBlackList(product.getName())) {
            return false;
        }

        /*İlgili ürün yasaklı listesinde değilse kategori listesine ekliyoruz*/
        category.getProducts().add(product);
        categoryRepositoryPort.save(category);

        /*İlgili kategori yasaklı listesinde değilse ürünün kategorilerine ekliyoruz*/
        if (categoryPolicyUseCases.isBlackList(category.getName())) {
            return false;
        }
        product.getCategories().add(category);
        productRepositoryPort.save(product);

        return true;
    }
}
