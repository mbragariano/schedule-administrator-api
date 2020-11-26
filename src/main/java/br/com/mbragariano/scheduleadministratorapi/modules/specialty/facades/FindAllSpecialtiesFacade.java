package br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;

import java.util.List;

public interface FindAllSpecialtiesFacade {

	List<SpecialtyDomain> execute();

}
