package br.com.mbragariano.gobeautyapi.common.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {

	@Bean
	public Validator getValidator(final MessageSource messageSource) {
		final var localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource);

		return localValidatorFactoryBean;
	}

}
