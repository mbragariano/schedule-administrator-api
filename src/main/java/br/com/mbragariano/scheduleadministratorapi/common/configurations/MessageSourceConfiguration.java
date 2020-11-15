package br.com.mbragariano.scheduleadministratorapi.common.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

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
