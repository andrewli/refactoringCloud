package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Swagger2
 * @Description 配置Swagger2
 * @Date 2019\9\24 0024 19:39
 * @Created by linfenghz
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2 {

    /*
          详细参考地址：https://www.cnblogs.com/Marydon20170307/p/14082450.html
          jar 包只需要引入 knife4j-spring-boot-starter 即可
          knife4j 文档地址：http://127.0.0.1:9194/sky5/doc.html
          版本与注解关系： 否则不可以
          knife4j： 2.0.6 以上   -----> @Configuration 和 @EnableSwagger2WebMvc
          knife4j： 2.0.4        -----> @Configuration 和 @EnableKnife4j 和 @EnableSwagger2
    */


    /**
    *  在 header 配置固定的header token 参数
    */
    @Bean
    public Docket createRestApi() {

        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder appHeaderParam = new ParameterBuilder();
        appHeaderParam.name("appToken")
                .description("app token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        ParameterBuilder webHeaderParam = new ParameterBuilder();
        webHeaderParam.name("token")
                .description("web token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        pars.add(appHeaderParam.build());
        pars.add(webHeaderParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目接口文档")
                .version("1.0")
                .build();
    }

}
