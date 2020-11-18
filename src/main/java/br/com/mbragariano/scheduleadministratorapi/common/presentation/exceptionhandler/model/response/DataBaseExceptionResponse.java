package br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DataBaseExceptionResponse extends BaseExceptionResponse {

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
