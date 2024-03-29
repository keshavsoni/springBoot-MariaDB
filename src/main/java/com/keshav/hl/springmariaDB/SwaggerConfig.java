package com.keshav.hl.springmariaDB;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/*@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}*/
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.keshav.hl.springmariaDB.controllers"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private Predicate<String> postPaths() {
		return or(regex("/.*"), regex("/mariadb.*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("KeshavLearnings API")
				.description("KeshavLearnings API reference for development")
				.termsOfServiceUrl("")
				.contact("soni.keshav1307@gmail.com")
				.license("KeshavLearnings License")
				.licenseUrl("soni.keshav1307@gmail.com@gmail.com")
				.version("1.0")
				.build();
	}
}
