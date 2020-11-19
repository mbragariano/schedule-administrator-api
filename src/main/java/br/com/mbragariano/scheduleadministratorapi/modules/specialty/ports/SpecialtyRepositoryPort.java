package br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;

public interface SpecialtyRepositoryPort {

	Boolean existsByName(String name);

	String create(SpecialtyDomain specialtyDomain);

}
