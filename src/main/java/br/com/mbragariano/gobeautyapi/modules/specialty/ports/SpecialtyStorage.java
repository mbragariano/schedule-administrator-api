package br.com.mbragariano.gobeautyapi.modules.specialty.ports;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;

import java.util.List;
import java.util.Optional;

public interface SpecialtyStorage {

	List<SpecialtyEntity> findAll();

	Boolean existsByName(String name);

	void create(SpecialtyEntity specialtyEntity);

	Optional<SpecialtyEntity> findByName(String name);

}
