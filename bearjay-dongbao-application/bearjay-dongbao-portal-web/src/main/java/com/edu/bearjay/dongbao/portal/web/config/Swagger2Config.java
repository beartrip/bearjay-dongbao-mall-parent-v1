package com.edu.bearjay.dongbao.portal.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author langyixiong
 * @date 2021/4/22 14:48
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edu.bearjay.dongbao.portal.web.controller"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfo("dongbao-mall swagger documentation",
                "商城API文档",
                "1.0",
                "urn:tos",
                new Contact("bearjay", "www.baidu.com", "1143716128@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
