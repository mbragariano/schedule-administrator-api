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

	public void validate(final Object object, final ValidationUtilMessages validationUtilMessages, final Class... groups) {
		final var validationResult = this.validator.validate(object, groups);

		if (!validationResult.isEmpty())
			throw new EntityValidationException(
				validationUtilMessages.message,
				validationUtilMessages.details,
				null,
				ValidationUtilMapper.mapToEntityValidations(validationResult)
			);
	}

}
