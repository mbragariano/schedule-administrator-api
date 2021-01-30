package br.com.mbragariano.gobeautyapi.modules.service.validations;

import br.com.mbragariano.gobeautyapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.gobeautyapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.gobeautyapi.modules.service.ports.ServiceStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistServiceByNameValidation {

	@Qualifier("serviceMongoDbStorage")
	private final ServiceStorage serviceStorage;

	public void validate(final String serviceName) {
		final var existsServiceEntity = this.serviceStorage.existsByName(serviceName);

		if (existsServiceEntity)
			throw new DuplicatedEntityException("Duplicated service by name", "There is already a service registered with that name", null);
	}

}
