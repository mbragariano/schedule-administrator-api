package br.com.mbragariano.scheduleadministratorapi.common.persistence.gateways;

import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.documents.SpecialtyDocument;

public class SpecialtyDocumentGateway {

	public static SpecialtyDocument mapToSpecialtyDocument(final SpecialtyDomain specialtyDomain) {
		return SpecialtyDocument.baseBuilder()
			.id(specialtyDomain.getId())
			.name(specialtyDomain.getName())
			.build();
	}
}
