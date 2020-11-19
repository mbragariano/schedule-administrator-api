package br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.dtos.CreateSpecialtyDto;

public interface CreateSpecialtyFacade {

  String execute(CreateSpecialtyDto createSpecialtyDto);

}
