package br.com.mbragariano.gobeautyapi.modules.service.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.SingleServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways.SpecialtyGateway;

import java.util.List;
import java.util.stream.Collectors;

public class SingleServiceGateway {

	public static List<SingleServiceEntity> mapToSingleServiceEntities(final List<SingleServiceDocument> singleServiceDocuments) {
		return singleServiceDocuments.stream().map(SingleServiceGateway::mapToSingleServiceEntity).collect(Collectors.toList());
	}

	private static SingleServiceEntity mapToSingleServiceEntity(final SingleServiceDocument singleServiceDocument) {
		return SingleServiceEntity.baseBuilder()
			.id(singleServiceDocument.id)
			.name(singleServiceDocument.name)
			.price(singleServiceDocument.price)
			.specialty(SpecialtyGateway.mapToSpecialtyEntity(singleServiceDocument.specialty))
			.build();
	}

	public static List<SingleServiceDocument> mapToSingleServiceDocuments(final List<SingleServiceEntity> singleServices) {
		return singleServices.stream().map(SingleServiceGateway::mapToSingleServiceDocument).collect(Collectors.toList());
	}

	public static SingleServiceDocument mapToSingleServiceDocument(final SingleServiceEntity singleServiceEntity) {
		return SingleServiceDocument.baseBuilder()
			.id(singleServiceEntity.getId())
			.name(singleServiceEntity.getName())
			.specialty(SpecialtyGateway.mapToSpecialtyDocument(singleServiceEntity.getSpecialty()))
			.price(singleServiceEntity.getPrice())
			.build();
	}

}
