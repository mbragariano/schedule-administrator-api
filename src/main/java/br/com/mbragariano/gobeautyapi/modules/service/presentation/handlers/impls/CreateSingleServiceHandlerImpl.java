package br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.impls;

import br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces.CreateServiceHandler;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateServiceRequest;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateSingleServiceRequest;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.presenters.CreateSingleServicePresenter;
import br.com.mbragariano.gobeautyapi.modules.service.usecases.interfaces.CreateSingleServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSingleServiceHandlerImpl implements CreateServiceHandler {

	private final CreateSingleServiceUseCase createSingleServiceUseCase;

	@Override
	public Boolean isTargetInstance(CreateServiceRequest createServiceRequest) {
		return createServiceRequest instanceof CreateSingleServiceRequest;
	}

	@Override
	public void handle(final CreateServiceRequest createServiceRequest) {
		final var createSingleServiceRequest = (CreateSingleServiceRequest) createServiceRequest;
		final var createSingleServiceDto = CreateSingleServicePresenter.mapToCreateSingleServiceDto(createSingleServiceRequest);

		this.createSingleServiceUseCase.execute(createSingleServiceDto);
	}

}
