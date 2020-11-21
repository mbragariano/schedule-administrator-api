package br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.documents.SpecialtyDocument;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllSpecialtiesGateway {

	public static List<SpecialtyDomain> mapToSpecialtyDomains(final List<SpecialtyDocument> specialtyDocuments) {
		return specialtyDocuments.stream().map(FindAllSpecialtiesGateway::mapToSpecialtyDomains).collect(Collectors.toList());
	}

	private static SpecialtyDomain mapToSpecialtyDomains(final SpecialtyDocument specialtyDocument) {
		return SpecialtyDomain.baseBuilder()
			.id(specialtyDocument.id)
			.name(specialtyDocument.name)
			.build();
	}

}
