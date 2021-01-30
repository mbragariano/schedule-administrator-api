package br.com.mbragariano.gobeautyapi.modules.service.mappers;

import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateCombinedServiceDto;
import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;

public class CreateCombinedServiceMapper {

	public static CombinedServiceEntity mapToCombinedServiceEntity(final CreateCombinedServiceDto createCombinedServiceDto) {
		return CombinedServiceEntity.baseBuilder()
			.name(createCombinedServiceDto.name)
			.discountPercentage(createCombinedServiceDto.discountPercentage)
			.build();
	}

}
