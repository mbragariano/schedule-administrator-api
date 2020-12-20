package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialtyGateway {

	public static SpecialtyDocument mapToSpecialtyDocument(final SpecialtyEntity specialtyEntity) {
		return SpecialtyDocument.baseBuilder()
			.id(specialtyEntity.getId())
			.name(specialtyEntity.getName())
			.build();
	}

	public static List<SpecialtyEntity> mapToSpecialtyEntities(final List<SpecialtyDocument> specialtyDocuments) {
		return specialtyDocuments.stream().map(SpecialtyGateway::mapToSpecialtyEntities).collect(Collectors.toList());
	}

	private static SpecialtyEntity mapToSpecialtyEntities(final SpecialtyDocument specialtyDocument) {
		return SpecialtyEntity.baseBuilder()
			.id(specialtyDocument.id)
			.name(specialtyDocument.name)
			.build();
	}

}
