package br.com.mbragariano.scheduleadministratorapi.modules.specialty.usecases;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.UseCase;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.FindAllSpecialtiesFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports.SpecialtyRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllSpecialtiesUseCase implements FindAllSpecialtiesFacade {

	private final SpecialtyRepositoryPort specialtyRepositoryPort;

	@Override
	public List<SpecialtyDomain> execute() {
		return this.specialtyRepositoryPort.findAll();
	}

}
