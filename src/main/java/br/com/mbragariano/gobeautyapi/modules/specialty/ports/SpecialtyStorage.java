package br.com.mbragariano.gobeautyapi.modules.specialty.ports;

import br.com.mbragariano.gobeautyapi.modules.specialty.domains.SpecialtyDomain;

import java.util.List;

public interface SpecialtyStorage {

	List<SpecialtyDomain> findAll();

	Boolean existsByName(String name);

	void create(SpecialtyDomain specialtyDomain);

}
