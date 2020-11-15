package br.com.mbragariano.scheduleadministratorapi.common.adapters;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Adapter;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolverPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Adapter
@RequiredArgsConstructor
public class MessageSourceResolverAdapter implements MessageResolverPort {

	private final MessageSource messageSource;

	@Override
	public String resolveMessage(String code, Object[] params, Locale locale) {
		return this.messageSource.getMessage(code, params, locale);
	}

}
