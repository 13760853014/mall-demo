package com.jianke.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class ApiConfig{

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("多点优惠")
                .description("多点优惠开发文档")
                .version("1.0.0")
                .termsOfServiceUrl("http://test.dangqugame.cn/")
                .license("dangqugame")
                .licenseUrl("http://test.dangqugame.cn/")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.jianke.demo.resource"))
            .paths(PathSelectors.any())
            .build();
    }


}