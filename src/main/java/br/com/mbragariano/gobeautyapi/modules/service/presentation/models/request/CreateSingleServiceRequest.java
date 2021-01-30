package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@JsonTypeName(CreateSingleServiceRequest.JSON_TYPE_NAME)
public class CreateSingleServiceRequest extends CreateServiceRequest {

	public static final String JSON_TYPE_NAME = "single";

	@JsonProperty
	public BigDecimal price;

	@JsonProperty
	public String specialtyName;

	@Builder(builderMethodName = "baseBuilder")
	public CreateSingleServiceRequest(final String name, final BigDecimal price, final String specialtyName) {
		super(name);

		this.price = price;
		this.specialtyName = specialtyName;
	}

}
