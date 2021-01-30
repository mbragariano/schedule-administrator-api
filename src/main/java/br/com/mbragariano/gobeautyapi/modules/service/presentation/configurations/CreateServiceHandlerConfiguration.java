package br.com.mbragariano.gobeautyapi.modules.service.presentation.configurations;

import br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces.CreateServiceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CreateServiceHandlerConfiguration {

	private final CreateServiceHandler createSingleServiceHandlerImpl;
	private final CreateServiceHandler createCombinedServiceHandlerImpl;

	@Bean
	public List<CreateServiceHandler> getCreateServiceHandlers() {
		return List.of(this.createSingleServiceHandlerImpl, this.createCombinedServiceHandlerImpl);
	}

}
