package br.com.mbragariano.gobeautyapi.modules.service.persistence.repositories;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.CombinedServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.gateways.CombinedServiceGateway;
import br.com.mbragariano.gobeautyapi.modules.service.ports.CombinedServiceStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@RequiredArgsConstructor
@Adapter("combinedServiceMongoDbStorage")
public class CombinedServiceMongoDbStorage implements CombinedServiceStorage {

	private final MongoTemplate mongoTemplate;

	@Override
	public void create(final CombinedServiceEntity combinedServiceEntity) {
		this.mongoTemplate.save(CombinedServiceGateway.mapToCombinedServiceDocument(combinedServiceEntity));
	}

}
