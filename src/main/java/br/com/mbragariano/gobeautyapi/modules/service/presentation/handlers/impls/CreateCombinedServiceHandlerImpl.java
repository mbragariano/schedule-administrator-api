package br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.impls;

import br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces.CreateServiceHandler;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateCombinedServiceRequest;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateServiceRequest;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.presenters.CreateCombinedServicePresenter;
import br.com.mbragariano.gobeautyapi.modules.service.usecases.interfaces.CreateCombinedServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCombinedServiceHandlerImpl implements CreateServiceHandler {

	private final CreateCombinedServiceUseCase createCombinedServiceUseCase;

	@Override
	public Boolean isTargetInstance(final CreateServiceRequest createServiceRequest) {
		return createServiceRequest instanceof CreateCombinedServiceRequest;
	}

	@Override
	public void handle(final CreateServiceRequest createServiceRequest) {
		final var createSingleServiceRequest = (CreateCombinedServiceRequest) createServiceRequest;
		final var createSingleServiceDto = CreateCombinedServicePresenter.mapToCreateCombinedServiceDto(createSingleServiceRequest);

		this.createCombinedServiceUseCase.execute(createSingleServiceDto);
	}

}
