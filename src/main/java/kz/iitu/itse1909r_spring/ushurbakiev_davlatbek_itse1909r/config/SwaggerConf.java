package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConf {



    public Predicate<String> postPaths() {
        return ((Predicate<String>) regex("/api/posts.*")::apply).or(regex("/api/javainuse.*")::apply);
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Lab 9 API")
                .description("Lab 9 API reference for developers")
                .termsOfServiceUrl("https://dl.iitu.kz")
                .contact("dushurbakiev@gmail.com").license("itse1909r License")
                .licenseUrl("dushurbakiev@gmail.com").version("1.0").build();
    }

}
