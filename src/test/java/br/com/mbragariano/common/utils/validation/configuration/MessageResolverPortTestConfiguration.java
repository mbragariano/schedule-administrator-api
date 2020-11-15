package br.com.mbragariano.common.utils.validation.configuration;

import br.com.mbragariano.scheduleadministratorapi.common.adapters.MessageSourceResolverAdapter;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolverPort;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MessageResolverPortTestConfiguration {

	@Bean
	public MessageResolverPort messageSourceResolverAdapter(final MessageSource messageSource) {
		return new MessageSourceResolverAdapter(messageSource);
	}

}
