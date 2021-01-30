package br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = Id.NAME, property = "type", defaultImpl = CreateSingleServiceRequest.class)
@JsonSubTypes(value = {
	@Type(value = CreateSingleServiceRequest.class, name = CreateSingleServiceRequest.JSON_TYPE_NAME),
	@Type(value = CreateCombinedServiceRequest.class, name = CreateCombinedServiceRequest.JSON_TYPE_NAME)
})
public abstract class CreateServiceRequest {

	@JsonProperty
	public String name;

}
