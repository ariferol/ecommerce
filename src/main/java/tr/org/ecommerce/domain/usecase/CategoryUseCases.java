package tr.org.ecommerce.domain.usecase;

import tr.org.ecommerce.domain.model.common.ID;

public interface CategoryUseCases {

    boolean addProductToCategory(ID categoryId, ID productId);

}
