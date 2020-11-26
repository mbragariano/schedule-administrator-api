package br.com.mbragariano.common.utils.validation.configuration;

import br.com.mbragariano.scheduleadministratorapi.common.adapters.MessageSourceResolver;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MessageResolverPortTestConfiguration {

	@Bean
	public MessageResolver messageSourceResolverAdapter(final MessageSource messageSource) {
		return new MessageSourceResolver(messageSource);
	}

}
