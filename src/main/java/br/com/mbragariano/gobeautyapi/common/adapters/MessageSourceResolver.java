package br.com.mbragariano.gobeautyapi.common.adapters;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.common.ports.MessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Adapter
@RequiredArgsConstructor
public class MessageSourceResolver implements MessageResolver {

	private final MessageSource messageSource;

	@Override
	public String resolveMessage(String code, Object[] params, Locale locale) {
		return this.messageSource.getMessage(code, params, locale);
	}

}
