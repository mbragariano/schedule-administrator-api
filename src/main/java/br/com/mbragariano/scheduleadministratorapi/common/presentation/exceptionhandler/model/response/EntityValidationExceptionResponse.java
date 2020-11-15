package br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.model.response;

import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException.EntityValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

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
