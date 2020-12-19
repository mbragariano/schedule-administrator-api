package br.com.mbragariano.gobeautyapi.common.utils.messageresolver;

import br.com.mbragariano.gobeautyapi.common.annotations.Util;
import br.com.mbragariano.gobeautyapi.common.ports.MessageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;

@Util
@RequiredArgsConstructor
public class MessageResolverUtil {

	@Qualifier("messageSourceResolver")
  private final MessageResolver messageResolver;

	public String resolveMessageWithoutParams(final String code) {
		return this.messageResolver.resolveMessage(code, new Object[]{}, LocaleContextHolder.getLocale());
	}

}
