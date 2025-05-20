package tr.org.ecommerce.domain.model.product.service;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.domain.model.common.policy.BlacklistedProduct;
import tr.org.ecommerce.domain.usecase.ProductPolicyUseCases;

//@Component
public class ProductPolicyService implements ProductPolicyUseCases {

    @Override
    public boolean isBlackList(String name) {
        return BlacklistedProduct.isBlacklisted(name);
    }
}
