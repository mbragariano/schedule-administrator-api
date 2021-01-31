package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses;

import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException.EntityValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@ApiModel
public class EntityValidationExceptionResponse extends BaseExceptionResponse {

	@JsonProperty
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
