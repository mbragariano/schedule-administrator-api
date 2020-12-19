package br.com.mbragariano.gobeautyapi.common.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

@Configuration
public class MessageSourceConfiguration {

	@Bean
	public MessageSource messageSource() {
		final var reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();

		reloadableResourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
		reloadableResourceBundleMessageSource.setBasename("classpath:messages");
		reloadableResourceBundleMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());

		return reloadableResourceBundleMessageSource;
	}

}
