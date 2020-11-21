package br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;

import java.util.List;

public interface SpecialtyStorage {

	List<SpecialtyDomain> findAll();

	Boolean existsByName(String name);

	void create(SpecialtyDomain specialtyDomain);

}
