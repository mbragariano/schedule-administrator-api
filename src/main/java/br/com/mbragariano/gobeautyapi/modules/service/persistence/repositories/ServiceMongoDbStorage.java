package br.com.mbragariano.gobeautyapi.modules.service.persistence.repositories;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.ServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.service.ports.ServiceStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@RequiredArgsConstructor
@Adapter("serviceMongoDbStorage")
public class ServiceMongoDbStorage implements ServiceStorage {

	private final MongoTemplate mongoTemplate;

	@Override
	public Boolean existsByName(final String name) {
		final var criteria = Criteria.where("name").is(name);
		final var query = new Query(criteria);

		return this.mongoTemplate.exists(query, ServiceDocument.class);
	}

}
