package br.com.mbragariano.scheduleadministratorapi.common.utils.validation;

import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException;
import lombok.RequiredArgsConstructor;

import javax.validation.Validator;

@RequiredArgsConstructor
public class ValidationUtil {

	private final Validator validator;

	public void validate(final Object object, final ValidationUtilMessages validationUtilMessages, final Class... groups) {
		final var validationResult = this.validator.validate(object, groups);

		if (!validationResult.isEmpty())
			throw new EntityValidationException(
				validationUtilMessages.message,
				validationUtilMessages.details,
				validationUtilMessages.developerMessage,
				ValidationUtilMapper.mapToEntityValidations(validationResult)
			);
	}

}
