package br.com.mbragariano.gobeautyapi.modules.service.presentation.presenters;

import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateSingleServiceDto;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateSingleServiceRequest;

public class CreateSingleServicePresenter {

	public static CreateSingleServiceDto mapToCreateSingleServiceDto(
		final CreateSingleServiceRequest createSingleServiceRequest
	) {
		return CreateSingleServiceDto.baseBuilder()
			.name(createSingleServiceRequest.name)
			.price(createSingleServiceRequest.price)
			.specialtyName(createSingleServiceRequest.specialtyName)
			.build();
	}

}
