package br.com.mbragariano.scheduleadministratorapi.modules.specialty.mappers;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.dtos.CreateSpecialtyDto;

public class CreateSpecialtyMapper {

	public static SpecialtyDomain mapToSpecialtyDomain(final CreateSpecialtyDto createSpecialtyDto) {
		return SpecialtyDomain.baseBuilder().name(createSpecialtyDto.name).build();
	}

}
