package br.com.mbragariano.gobeautyapi.common.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Configuration
public class LanguageConfiguration {

	private static final List<Locale> SUPPORTED_LOCALES = Collections.singletonList(Locale.US);

	@Bean
	public LocaleResolver localeResolver() {
		final var acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
		acceptHeaderLocaleResolver.setSupportedLocales(SUPPORTED_LOCALES);

		return acceptHeaderLocaleResolver;
	}

}
