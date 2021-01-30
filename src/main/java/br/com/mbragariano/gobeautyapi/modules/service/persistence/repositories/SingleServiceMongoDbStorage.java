package br.com.mbragariano.gobeautyapi.modules.service.persistence.repositories;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.SingleServiceDocument;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.gateways.SingleServiceGateway;
import br.com.mbragariano.gobeautyapi.modules.service.ports.SingleServiceStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter("singleServiceMongoDbStorage")
public class SingleServiceMongoDbStorage implements SingleServiceStorage {

	private final MongoTemplate mongoTemplate;

	@Override
	public List<SingleServiceEntity> findByIds(final List<String> ids) {
		final var criteria = Criteria.where("_id").in(ids);

		final var query = new Query(criteria);

		final var singleServiceDocuments = this.mongoTemplate.find(query, SingleServiceDocument.class);

		return SingleServiceGateway.mapToSingleServiceEntities(singleServiceDocuments);
	}

	@Override
	public void create(final SingleServiceEntity singleServiceEntity) {
		this.mongoTemplate.save(SingleServiceGateway.mapToSingleServiceDocument(singleServiceEntity));
	}

}
