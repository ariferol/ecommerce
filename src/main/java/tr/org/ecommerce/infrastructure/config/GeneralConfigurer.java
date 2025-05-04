package tr.org.ecommerce.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfigurer {

    /*Swagger url icin http://hostyadaip:port/swagger-ui/index.html*/
    @Bean
    public OpenAPI customOpenAPI(@Value("${app.description}") String description, @Value("${app.version}") String version) {
        return new OpenAPI()
                .info(new Info().title("Clean Hexagonal demo project")
                        .version(version)
                        .description(description)
                        .license(new License().name("Clean Hexagonal demo project API - MIT License")));
    }
}
