package br.com.mbragariano.scheduleadministratorapi.modules.specialty.usecases;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.UseCase;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.FindAllSpecialtiesFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports.SpecialtyStorage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllSpecialtiesUseCase implements FindAllSpecialtiesFacade {

	private final SpecialtyStorage specialtyStorage;

	@Override
	public List<SpecialtyDomain> execute() {
		return this.specialtyStorage.findAll();
	}

}
