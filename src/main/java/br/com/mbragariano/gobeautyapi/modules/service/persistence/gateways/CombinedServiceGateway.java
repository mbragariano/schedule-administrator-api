package br.com.mbragariano.gobeautyapi.modules.service.persistence.gateways;

import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.CombinedServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.SingleServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways.SpecialtyGateway;

import java.util.List;

public class CombinedServiceGateway {

	public static CombinedServiceDocument mapToCombinedServiceDocument(final CombinedServiceEntity combinedServiceEntity) {
		return CombinedServiceDocument.baseBuilder()
			.id(combinedServiceEntity.getId())
			.name(combinedServiceEntity.getName())
			.discountPercentage(combinedServiceEntity.getDiscountPercentage())
			.specialties(CombinedServiceGateway.getSpecialtyDocuments(combinedServiceEntity))
			.singleServices(CombinedServiceGateway.getSingleServiceDocuments(combinedServiceEntity))
			.build();
	}

	private static List<SpecialtyDocument> getSpecialtyDocuments(final CombinedServiceEntity combinedServiceEntity) {
		return SpecialtyGateway.mapToSpecialtyDocuments(combinedServiceEntity.getSpecialties());
	}

	private static List<SingleServiceDocument> getSingleServiceDocuments(final CombinedServiceEntity combinedServiceEntity) {
		return SingleServiceGateway.mapToSingleServiceDocuments(combinedServiceEntity.getSingleServices());
	}

}
