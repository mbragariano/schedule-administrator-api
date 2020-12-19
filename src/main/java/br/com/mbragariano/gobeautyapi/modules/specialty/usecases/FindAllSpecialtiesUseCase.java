package br.com.mbragariano.gobeautyapi.modules.specialty.usecases;

import br.com.mbragariano.gobeautyapi.common.annotations.UseCase;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.facades.FindAllSpecialtiesFacade;
import br.com.mbragariano.gobeautyapi.modules.specialty.ports.SpecialtyStorage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllSpecialtiesUseCase implements FindAllSpecialtiesFacade {

	private final SpecialtyStorage specialtyStorage;

	@Override
	public List<SpecialtyEntity> execute() {
		return this.specialtyStorage.findAll();
	}

}
