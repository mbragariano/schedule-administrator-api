package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.presenters;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.dtos.CreateSpecialtyDto;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.model.request.CreateSpecialtyRequest;

public class CreateSpecialtyPresenter {

	public static CreateSpecialtyDto mapToCreateSpecialtyDto(final CreateSpecialtyRequest createSpecialtyRequest) {
		return new CreateSpecialtyDto(createSpecialtyRequest.name);
	}

}
