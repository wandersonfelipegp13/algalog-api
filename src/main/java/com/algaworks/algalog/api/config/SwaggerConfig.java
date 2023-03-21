package com.algaworks.algalog.api.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${contato.nome}")
	private String contatoNome;
	
	@Value("${contato.site}")
	private String contatoSite;
	
	@Value("${contato.email}")
	private String contatoEmail;
	
	private Contact contato() {
		return new Contact(contatoNome, contatoSite, contatoEmail);
	}
	
	public ApiInfoBuilder informacoesApi() {
		
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		
		apiInfoBuilder.title("AlgaLog API");
		apiInfoBuilder.description("API REST para gerenciamento de um sistema de Logística.");
		apiInfoBuilder.version("1.0");
		// apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		// apiInfoBuilder.license("");
		// apiInfoBuilder.licenseUrl("");
		apiInfoBuilder.contact(contato());
		
		return apiInfoBuilder;
		
	}

    @Bean
    Docket detalheApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.algaworks.algalog.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;

    }

}
