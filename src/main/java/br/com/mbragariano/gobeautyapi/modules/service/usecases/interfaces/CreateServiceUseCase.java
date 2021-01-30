package br.com.mbragariano.gobeautyapi.modules.service.usecases.interfaces;

import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateServiceDto;

interface CreateServiceUseCase<T extends CreateServiceDto> {

	void execute(T t);

}
