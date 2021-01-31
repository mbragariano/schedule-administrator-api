package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel
public class DataBaseExceptionResponse extends BaseExceptionResponse {

	@JsonProperty
	public Integer errorCode;

	@Builder(builderMethodName = "inheritanceBuilde")
	public DataBaseExceptionResponse(
		final Integer status,
		final String message,
		final String details,
		final String exceptionType,
		final String developerMessage,
		final Integer errorCode
	) {
		super(status, message, details, exceptionType, developerMessage);

		this.errorCode = errorCode;
	}

}
