package br.com.mbragariano.gobeautyapi.common.presentation.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class IdResponse {

	@JsonProperty
	public String id;

}
