package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@ApiModel
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
