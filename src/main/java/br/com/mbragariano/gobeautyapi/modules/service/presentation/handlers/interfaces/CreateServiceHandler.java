package br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces;

import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateServiceRequest;

public interface CreateServiceHandler {

	void handle(CreateServiceRequest createServiceRequest);

	Boolean isTargetInstance(CreateServiceRequest createServiceRequest);

}
