package fses.fms.conf;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket publicApi(ServletContext servletContext) {

        return new Docket(DocumentationType.SWAGGER_2)
                .host("https://test")
                .useDefaultResponseMessages(false)
                .select()
                .paths(includePath(new String[]{
                        "/test",

                }))
                .build()
                .apiInfo(apiInfo())
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()));

    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Title",
                "Description ",
                "API 0.0.1 - Beta",
                "terms OfServiceUrl",
                new Contact("Michal Nawrocki", null, "michal@test.net"),
                "License of API",
                "API license URL",
                new Vector<VendorExtension>()
        );

    }

    private ApiKey apiKey() {
        return new ApiKey(
                "JWT", // name: My key - Authorization
                "Authorization", // keyname: api_key
                "header");
    }

    Predicate<String> includePath(String[] path) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {

                for (String i : path) {

                    if (input.startsWith(i)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

}
