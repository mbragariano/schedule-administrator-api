package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses;

import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException.EntityValidation;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
public class EntityValidationExceptionResponse extends BaseExceptionResponse {

	public Set<EntityValidation> validations;

	@Builder(builderMethodName = "inheritanceBuilder")
	public EntityValidationExceptionResponse(
		final Integer status,
		final String message,
		final String details,
		final String exceptionType,
		final Set<EntityValidation> validations
	) {
		super(status, message, details, exceptionType, null);

		this.validations = validations;
	}

}
