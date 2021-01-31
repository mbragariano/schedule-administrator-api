package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@ApiModel(description = "Subtype service", parent = CreateServiceRequest.class)
@JsonTypeName(CreateSingleServiceRequest.JSON_TYPE_NAME)
public class CreateSingleServiceRequest extends CreateServiceRequest {

	public static final String JSON_TYPE_NAME = "single";

	@JsonProperty
	@ApiModelProperty(required = true)
	public BigDecimal price;

	@JsonProperty
	@ApiModelProperty(required = true)
	public String specialtyName;

}
