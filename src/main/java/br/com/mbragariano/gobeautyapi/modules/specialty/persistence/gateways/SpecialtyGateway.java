package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialtyGateway {

	public static List<SpecialtyEntity> mapToSpecialtyEntities(final List<SpecialtyDocument> specialtyDocuments) {
		return specialtyDocuments.stream().map(SpecialtyGateway::mapToSpecialtyEntity).collect(Collectors.toList());
	}

	public static SpecialtyEntity mapToSpecialtyEntity(final SpecialtyDocument specialtyDocument) {
		return SpecialtyEntity.baseBuilder()
			.id(specialtyDocument.id)
			.name(specialtyDocument.name)
			.build();
	}

	public static List<SpecialtyDocument> mapToSpecialtyDocuments(final List<SpecialtyEntity> specialties) {
		return specialties.stream().map(SpecialtyGateway::mapToSpecialtyDocument).collect(Collectors.toList());
	}

	public static SpecialtyDocument mapToSpecialtyDocument(final SpecialtyEntity specialtyEntity) {
		return SpecialtyDocument.baseBuilder()
			.id(specialtyEntity.getId())
			.name(specialtyEntity.getName())
			.build();
	}

}
