package br.com.mbragariano.gobeautyapi.common.presentation.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Set;

@Configuration
public class SwaggerConfiguration {

	private static final Set<String> PROTOCOLS = Set.of("http");
	private static final Set<String> CONSUMES_AND_PRODUCES = Set.of("application/json");

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(this.getApiInfo())
			.consumes(CONSUMES_AND_PRODUCES)
			.produces(CONSUMES_AND_PRODUCES)
			.protocols(PROTOCOLS)
			.tags(this.getFirstTag(), this.getOderTags())
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.regex("/error.*?").negate())
			.build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
			.title("Go Beauty Api")
			.description("Backend for handling appointments in beauty salons")
			.contact(this.getContact())
			.build();
	}

	private Contact getContact() {
		return new Contact("Matheus da Silva Braga", "https://github.com/mbragariano", "matheus.braga.work@gmail.com");
	}

	private Tag getFirstTag() {
		return new Tag("Specialty", "Specialty endpoints related");
	}

	private Tag[] getOderTags() {
		return new Tag[]{
			new Tag("Service", "Service endpoints related")
		};
	}

}
