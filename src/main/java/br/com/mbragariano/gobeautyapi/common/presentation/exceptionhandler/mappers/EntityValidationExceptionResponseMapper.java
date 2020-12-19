package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers;

import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.EntityValidationExceptionResponse;
import org.springframework.http.HttpStatus;

public class EntityValidationExceptionResponseMapper {

	public static EntityValidationExceptionResponse mapToEntityValidationExceptionResponse(
		final EntityValidationException entityValidationException,
		final HttpStatus httpStatus
	) {
		return EntityValidationExceptionResponse.inheritanceBuilder()
			.status(httpStatus.value())
			.message(entityValidationException.getMessage())
			.details(entityValidationException.getDetails())
			.validations(entityValidationException.getValidations())
			.exceptionType(entityValidationException.getClass().getSimpleName())
			.build();
	}

}
