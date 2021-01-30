package br.com.mbragariano.gobeautyapi.modules.service.dtos;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class CreateCombinedServiceDto extends CreateServiceDto {

	public List<String> serviceIds;

	public BigDecimal discountPercentage;

	@Builder(builderMethodName = "baseBuilder")
	public CreateCombinedServiceDto(
		final String name,
		final List<String> serviceIds,
		final BigDecimal discountPercentage
	) {
		super(name);

		this.serviceIds = serviceIds;
		this.discountPercentage = discountPercentage;
	}
}
