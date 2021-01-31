package br.com.mbragariano.gobeautyapi.modules.specialty.presentation.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecialtyRequest {

	@JsonProperty
	@ApiModelProperty(required = true)
	public String name;

}
