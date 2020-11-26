package br.com.mbragariano.scheduleadministratorapi.common.utils.validation;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Util;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolver;
import br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver.MessageResolverUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.Validator;

@Util
@RequiredArgsConstructor
public class ValidationUtil {

	private final Validator validator;

	private final MessageResolverUtil messageResolverUtil;

	public void validate(final Object object, final ValidationUtilMessages validationUtilMessages, final Class... groups) {
		final var validationResult = this.validator.validate(object, groups);

		if (!validationResult.isEmpty())
			throw new EntityValidationException(
				this.messageResolverUtil.resolveMessageWithoutParams(validationUtilMessages.message),
				this.messageResolverUtil.resolveMessageWithoutParams(validationUtilMessages.details),
				null,
				ValidationUtilMapper.mapToEntityValidations(validationResult)
			);
	}

}
