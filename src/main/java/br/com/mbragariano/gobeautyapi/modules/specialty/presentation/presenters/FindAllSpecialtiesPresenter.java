package br.com.mbragariano.gobeautyapi.modules.specialty.presentation.presenters;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.models.responses.FindAllSpecialtiesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllSpecialtiesPresenter {

	public static List<FindAllSpecialtiesResponse> mapToFindAllSpecialtiesResponse(
		final List<SpecialtyEntity> specialtySpecialties
	) {
		return specialtySpecialties.stream().map(FindAllSpecialtiesPresenter::mapToFindAllSpecialtiesResponse).collect(Collectors.toList());
	}

	private static FindAllSpecialtiesResponse mapToFindAllSpecialtiesResponse(final SpecialtyEntity specialtyEntity) {
		return FindAllSpecialtiesResponse.builder()
			.id(specialtyEntity.getId())
			.name(specialtyEntity.getName())
			.build();
	}

}
