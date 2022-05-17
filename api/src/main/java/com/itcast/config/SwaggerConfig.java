package com.itcast.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/13 17:03
 * @Description swagger的配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 帮助我们的接口文档
     * 1. 配置文档信息
     * 2. 配置接口信息
     * 封装接口文档信息
     * @return
     */
    @Bean
    public Docket getDocket() {
        // 指定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        // 文档封面信息 标题 版本 作者等
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后台接口文档")
                .description("说明了锋迷商城后端接口的规范...")
                .version("v2.0.1")
                .contact(new Contact("fengjun", "www.fengjun.com", "fj13464498017@163.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();
        // 指定生成策略
        docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itcast.fmmall.controller"))
                .paths(PathSelectors.any()).build();
        return docket;
    }


}
