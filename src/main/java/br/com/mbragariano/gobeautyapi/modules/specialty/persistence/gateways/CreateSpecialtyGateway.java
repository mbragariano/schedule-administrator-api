package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;

public class CreateSpecialtyGateway {

	public static SpecialtyDocument mapToSpecialtyDocument(final SpecialtyEntity specialtyEntity) {
		return SpecialtyDocument.baseBuilder()
			.id(specialtyEntity.getId())
			.name(specialtyEntity.getName())
			.build();
	}
}
