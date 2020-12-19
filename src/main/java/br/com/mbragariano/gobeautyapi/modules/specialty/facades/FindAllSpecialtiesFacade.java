package br.com.mbragariano.gobeautyapi.modules.specialty.facades;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;

import java.util.List;

public interface FindAllSpecialtiesFacade {

	List<SpecialtyEntity> execute();

}
