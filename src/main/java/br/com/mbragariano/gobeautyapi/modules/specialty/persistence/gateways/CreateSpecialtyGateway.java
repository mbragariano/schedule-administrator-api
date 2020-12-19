package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;

public class CreateSpecialtyGateway {

	public static SpecialtyDocument mapToSpecialtyDocument(final SpecialtyDomain specialtyDomain) {
		return SpecialtyDocument.baseBuilder()
			.id(specialtyDomain.getId())
			.name(specialtyDomain.getName())
			.build();
	}
}
