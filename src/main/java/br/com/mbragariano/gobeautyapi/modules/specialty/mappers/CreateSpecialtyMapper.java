package br.com.mbragariano.gobeautyapi.modules.specialty.mappers;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.dtos.CreateSpecialtyDto;

public class CreateSpecialtyMapper {

	public static SpecialtyEntity mapToSpecialtyEntity(final CreateSpecialtyDto createSpecialtyDto) {
		return SpecialtyEntity.baseBuilder().name(createSpecialtyDto.name).build();
	}

}
