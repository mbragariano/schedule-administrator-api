package br.com.mbragariano.gobeautyapi.common.utils.validation;

import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException.EntityValidation;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationUtilMapper {

	public static Set<EntityValidation> mapToEntityValidations(
		final Set<ConstraintViolation<Object>> constraintViolations
	) {
		return constraintViolations.stream().map(ValidationUtilMapper::mapToEntityValidation).collect(Collectors.toSet());
	}

	private static EntityValidation mapToEntityValidation(final ConstraintViolation<Object> constraintViolation) {
		return EntityValidation.builder()
			.message(constraintViolation.getMessage())
			.value(constraintViolation.getInvalidValue())
			.relatedWith(constraintViolation.getPropertyPath().toString())
			.build();
	}

}
