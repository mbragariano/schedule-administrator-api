package br.com.mbragariano.gobeautyapi.common.utils.validation;

import br.com.mbragariano.gobeautyapi.common.annotations.Util;
import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.gobeautyapi.common.utils.messageresolver.MessageResolverUtil;
import lombok.RequiredArgsConstructor;

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
