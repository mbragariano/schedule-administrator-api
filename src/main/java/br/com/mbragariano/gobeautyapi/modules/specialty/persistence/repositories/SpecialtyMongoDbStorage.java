package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.repositories;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways.SpecialtyGateway;
import br.com.mbragariano.gobeautyapi.modules.specialty.ports.SpecialtyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Adapter("specialtyMongoDbStorage")
public class SpecialtyMongoDbStorage implements SpecialtyStorage {

	private final MongoTemplate mongoTemplate;

	@Override
	public List<SpecialtyEntity> findAll() {
		final var specialtyDocuments = this.mongoTemplate.findAll(SpecialtyDocument.class);

		return SpecialtyGateway.mapToSpecialtyEntities(specialtyDocuments);
	}

	@Override
	public Boolean existsByName(final String name) {
		final var query = this.getIsNameQuery(name);

		return this.mongoTemplate.exists(query, SpecialtyDocument.class);
	}

	@Override
	public void create(final SpecialtyEntity specialtyEntity) {
		final var specialtyDocument = SpecialtyGateway.mapToSpecialtyDocument(specialtyEntity);

		this.mongoTemplate.save(specialtyDocument);
	}

	@Override
	public Optional<SpecialtyEntity> findByName(final String name) {
		final var query = this.getIsNameQuery(name);
		final var specialtyDocument = this.mongoTemplate.findOne(query, SpecialtyDocument.class);

		return Optional.ofNullable(specialtyDocument).map(SpecialtyGateway::mapToSpecialtyEntity);
	}

	private Query getIsNameQuery(final String value) {
		return new Query(Criteria.where("name").is(value));
	}

}
