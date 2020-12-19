package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllSpecialtiesGateway {

	public static List<SpecialtyEntity> mapToSpecialtyEntities(final List<SpecialtyDocument> specialtyDocuments) {
		return specialtyDocuments.stream().map(FindAllSpecialtiesGateway::mapToSpecialtyEntities).collect(Collectors.toList());
	}

	private static SpecialtyEntity mapToSpecialtyEntities(final SpecialtyDocument specialtyDocument) {
		return SpecialtyEntity.baseBuilder()
			.id(specialtyDocument.id)
			.name(specialtyDocument.name)
			.build();
	}

}
