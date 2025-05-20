package tr.org.ecommerce.domain.model.category.service;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.domain.model.common.policy.BlacklistedCategory;
import tr.org.ecommerce.domain.model.common.policy.BlacklistedProduct;
import tr.org.ecommerce.domain.usecase.CategoryPolicyUseCases;

//@Component
public class CategoryPolicyService implements CategoryPolicyUseCases {

    @Override
    public boolean isBlackList(String name) {
        return BlacklistedCategory.isBlacklisted(name);
    }

}
