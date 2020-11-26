package br.com.mbragariano.common.utils.validation.configuration;

import br.com.mbragariano.scheduleadministratorapi.common.adapters.MessageSourceResolver;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolver;
import br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver.MessageResolverUtil;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MessageResolverPortTestConfiguration {

	@Bean
	public MessageResolver messageResolver(final MessageSource messageSource) {
		return new MessageSourceResolver(messageSource);
	}

	@Bean
	public MessageResolverUtil messageSourceResolverAdapter(final MessageResolver messageResolver) {
		return new MessageResolverUtil(messageResolver);
	}

}
