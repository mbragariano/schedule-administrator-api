package br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;

public interface SpecialtyRepositoryStorage {

	Boolean existsByName(String name);

	void create(SpecialtyDomain specialtyDomain);

}
