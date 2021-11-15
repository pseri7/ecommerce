package com.egen.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
            return new ApiInfo(
                    "Order API",
                    "Order API for Ecommerce Application",
                    "1.0",
                    "Free to use",
            new springfox.documentation.service.Contact ( "Pavan Seri",
                    "https://www.linkedin.com/in/pavanseri/",
                    "seripavan7@gmail.com" ),

                     "API License",
                    "https://www.linkedin.com/in/pavanseri/",
            Collections.emptyList());

        }




}
