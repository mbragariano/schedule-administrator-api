package br.com.mbragariano.gobeautyapi.modules.specialty.facades;

import br.com.mbragariano.gobeautyapi.modules.specialty.domains.SpecialtyDomain;

import java.util.List;

public interface FindAllSpecialtiesFacade {

	List<SpecialtyDomain> execute();

}
