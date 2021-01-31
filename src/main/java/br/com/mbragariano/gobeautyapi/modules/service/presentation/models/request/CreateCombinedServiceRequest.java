package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@ApiModel(description = "Subtype service", parent = CreateServiceRequest.class)
@JsonTypeName(CreateSingleServiceRequest.JSON_TYPE_NAME)
public class CreateCombinedServiceRequest extends CreateServiceRequest {

	public static final String JSON_TYPE_NAME = "combined";

	@JsonProperty
	@ApiModelProperty(required = true)
	public List<String> serviceIds;

	@JsonProperty
	@ApiModelProperty(required = true)
	public BigDecimal discountPercentage;

}
