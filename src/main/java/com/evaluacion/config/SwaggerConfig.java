package com.evaluacion.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.AuthorizationScope;

public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.evaluacion.usuarios.controllers"))
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    
	}

    
	ApiInfo getApiInfo() {
		return new ApiInfo(
				"Evaluación Java",
				"Desarrolle una aplicación que exponga una API RESTful de creación de usuarios",
				"1.0",
				"https://trabajaenbci.cl/areas-de-interes",
				new Contact("BCI Empleos", "https://trabajaenbci.cl/", "soporte@trabajaenbci.cl"),
				"Licencia de la API",
				"URL asociadoa la licencia de la API",
				Collections.emptyList()
				);
	}
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
}