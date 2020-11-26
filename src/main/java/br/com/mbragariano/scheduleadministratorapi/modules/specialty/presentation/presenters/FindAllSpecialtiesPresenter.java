package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.presenters;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.models.responses.FindAllSpecialtiesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllSpecialtiesPresenter {

	public static List<FindAllSpecialtiesResponse> mapToFindAllSpecialtiesResponse(
		final List<SpecialtyDomain> specialtyDomains
	) {
		return specialtyDomains.stream().map(FindAllSpecialtiesPresenter::mapToFindAllSpecialtiesResponse).collect(Collectors.toList());
	}

	private static FindAllSpecialtiesResponse mapToFindAllSpecialtiesResponse(final SpecialtyDomain specialtyDomain) {
		return FindAllSpecialtiesResponse.builder()
			.id(specialtyDomain.getId())
			.name(specialtyDomain.getName())
			.build();
	}

}
