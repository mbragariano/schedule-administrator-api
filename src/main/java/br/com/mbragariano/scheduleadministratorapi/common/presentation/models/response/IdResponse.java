package br.com.mbragariano.scheduleadministratorapi.common.presentation.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class IdResponse {

	@JsonProperty
	public String id;

}
