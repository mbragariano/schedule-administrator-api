package br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class BaseExceptionResponse {

	@JsonProperty
	public Integer status;

	@JsonProperty
	public String message;

	@JsonProperty
	public String details;

	@JsonProperty
	public String exceptionType;

	@JsonProperty
	public String developerMessage;

}
