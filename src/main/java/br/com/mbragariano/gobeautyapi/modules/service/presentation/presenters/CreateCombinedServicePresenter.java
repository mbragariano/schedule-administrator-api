package br.com.mbragariano.gobeautyapi.modules.service.presentation.presenters;

import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateCombinedServiceDto;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateCombinedServiceRequest;

public class CreateCombinedServicePresenter {

	public static CreateCombinedServiceDto mapToCreateCombinedServiceDto(
		final CreateCombinedServiceRequest createCombinedServiceRequest
	) {
		return CreateCombinedServiceDto.baseBuilder()
			.name(createCombinedServiceRequest.name)
			.serviceIds(createCombinedServiceRequest.serviceIds)
			.discountPercentage(createCombinedServiceRequest.discountPercentage)
			.build();
	}

}
