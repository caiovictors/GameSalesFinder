package com.inatel.gamesalesfinder.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Game Sales Finder API").description("Aplication to find games best prices")
        .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").termsOfServiceUrl("")
        .version("1.0.0")
        .contact(new Contact("Caio Victor Sarmento", "https://github.com/caiovictors", "caio.victor@inatel.br"))
        .build();
  }

  @Bean
  public Docket swagger() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any()).build().apiInfo(apiInfo());
  }

}