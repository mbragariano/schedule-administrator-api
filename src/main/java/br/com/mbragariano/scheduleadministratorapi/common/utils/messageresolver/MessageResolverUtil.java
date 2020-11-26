package br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Util;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolver;
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
