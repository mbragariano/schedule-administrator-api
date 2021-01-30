package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@JsonTypeName(CreateSingleServiceRequest.JSON_TYPE_NAME)
public class CreateCombinedServiceRequest extends CreateServiceRequest {

	public static final String JSON_TYPE_NAME = "combined";

	@JsonProperty
	public List<String> serviceIds;

	@JsonProperty
	public BigDecimal discountPercentage;

}
