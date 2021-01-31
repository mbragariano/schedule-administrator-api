package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(
	discriminator = "type",
	description = "Supertype service",
	subTypes = {
		CreateSingleServiceRequest.class,
		CreateCombinedServiceRequest.class
	}
)
@JsonTypeInfo(use = Id.NAME, property = "type", defaultImpl = CreateSingleServiceRequest.class)
@JsonSubTypes(value = {
	@Type(value = CreateSingleServiceRequest.class, name = CreateSingleServiceRequest.JSON_TYPE_NAME),
	@Type(value = CreateCombinedServiceRequest.class, name = CreateCombinedServiceRequest.JSON_TYPE_NAME)
})
public abstract class CreateServiceRequest {

	@JsonProperty
	@ApiModelProperty(required = true)
	public String name;

	@JsonProperty
	@ApiModelProperty(allowableValues = "single, combined")
	public String type;

}
