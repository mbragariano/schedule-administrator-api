package br.com.mbragariano.gobeautyapi.modules.specialty.ports;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;

import java.util.List;

public interface SpecialtyStorage {

	List<SpecialtyEntity> findAll();

	Boolean existsByName(String name);

	void create(SpecialtyEntity specialtyEntity);

}
