package br.com.mbragariano.gobeautyapi.modules.service.mappers;

import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateSingleServiceDto;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;

public class CreateSingleServiceMapper {

	public static SingleServiceEntity mapToSingleServiceEntity(final CreateSingleServiceDto createSingleServiceDto) {
		return SingleServiceEntity.baseBuilder()
			.name(createSingleServiceDto.name)
			.price(createSingleServiceDto.price)
			.build();
	}

}
