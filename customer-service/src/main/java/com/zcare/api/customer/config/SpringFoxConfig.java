package com.zcare.api.customer.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zcare.api.customer.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "AlManhal Applicaiton",
                "This application describes the APIs provided by AlManhal system.",
                "1.0",
                "http://www.yasholding.ae/",
                new Contact("Mark Sinclair","http://www.yasholding.ae/L","Mark.Sincalir@secondstep.ae"),
                "Restricted",
                "http://www.yasholding.ae/",
                Collections.emptyList()
        );
    }
    
}