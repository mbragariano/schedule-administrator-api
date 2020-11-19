package br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Util;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolverPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Util
@RequiredArgsConstructor
public class MessageResolverUtil {

	@Qualifier("messageSourceResolverAdapter")
  private final MessageResolverPort messageResolverPort;

	public String resolveMessageWithoutParams(final String code) {
		return this.messageResolverPort.resolveMessage(code, new Object[]{}, LocaleContextHolder.getLocale());
	}

}
