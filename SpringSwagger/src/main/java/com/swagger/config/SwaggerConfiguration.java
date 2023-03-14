package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket swaggerconfig() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Swagger").apiInfo(apiInfo()).select()
				.paths(PathSelectors.ant("/employee/*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Swagger")
				                   .description("Sample Documentation Generated Using Swagger UI")
				                   .contact(new Contact("Prasanna Venkatesh", "www.prasannaswagger.net", "prasanna122@gmail.com"))
				                   .version("1.0")
				                   .build();
	}
	
}
