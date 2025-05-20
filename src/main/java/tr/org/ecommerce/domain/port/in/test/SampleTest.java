package tr.org.ecommerce.domain.port.in.test;


import org.springframework.http.ResponseEntity;
import tr.org.ecommerce.domain.model.product.dto.CreateProductCommandDto;
import tr.org.ecommerce.domain.model.product.dto.ProductDto;
import tr.org.ecommerce.domain.port.in.rest.ProductRestAPI;

import java.math.BigDecimal;
import java.util.UUID;

public class SampleTest {
    private final ProductRestAPI productRestAPI;

    public SampleTest(ProductRestAPI productRestAPI) {
        this.productRestAPI = productRestAPI;
    }

    void productCreateTest(){
        CreateProductCommandDto productCommandDto = new CreateProductCommandDto("Saat"
                ,"Kol saati"
                ,new BigDecimal("100.00")
                ,null
                ,35
                ,0
                ,0
                ,0
                ,0);
        ResponseEntity<ProductDto> response = this.productRestAPI.registerProduct(productCommandDto);

    }
}
