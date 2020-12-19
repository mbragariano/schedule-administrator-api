package br.com.mbragariano.gobeautyapi.modules.specialty.persistence.repositories;

import br.com.mbragariano.gobeautyapi.common.annotations.Adapter;
import br.com.mbragariano.gobeautyapi.common.exceptions.DataBaseException;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways.CreateSpecialtyGateway;
import br.com.mbragariano.gobeautyapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.gobeautyapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.ports.SpecialtyStorage;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.gateways.FindAllSpecialtiesGateway;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
@Adapter("specialtyMongoDbStorage")
public class SpecialtyMongoDbStorage implements SpecialtyStorage {

	private final MongoTemplate mongoTemplate;

	private final MessageResolverUtil messageResolverUtil;

	private static final String EXCEPTION_MESSAGE_WHEN_CREATE = "specialty.mongodb.repository.adapter.create.database.exception.message";
	private static final String EXCEPTION_DETAILS_WHEN_CREATE = "specialty.mongodb.repository.adapter.create.database.exception.details";

	private static final String EXCEPTION_MESSAGE_WHEN_FIND_ALL = "specialty.mongodb.repository.adapter.findAll.database.exception.message";
	private static final String EXCEPTION_DETAILS_WHEN_FIND_ALL = "specialty.mongodb.repository.adapter.findAll.database.exception.details";

	private static final String EXCEPTION_MESSAGE_WHEN_FIND_BY_NAME = "specialty.mongodb.repository.adapter.existsByName.database.exception.message";
	private static final String EXCEPTION_DETAILS_WHEN_FIND_BY_NAME = "specialty.mongodb.repository.adapter.existsByName.database.exception.details";

	@Override
	public List<SpecialtyDomain> findAll() {
		try {
			final var specialtyDocuments = this.mongoTemplate.findAll(SpecialtyDocument.class);

			return FindAllSpecialtiesGateway.mapToSpecialtyDomains(specialtyDocuments);
		} catch (final MongoException mongoException) {
			mongoException.printStackTrace();

			final var message = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_MESSAGE_WHEN_FIND_ALL);
			final var details = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_DETAILS_WHEN_FIND_ALL);

			throw new DataBaseException(message, details, mongoException.getMessage(), mongoException.getCode());
		}
	}

	@Override
	public Boolean existsByName(final String name) {
		try {
			final var query = new Query(Criteria.where("name").is(name));

			return this.mongoTemplate.exists(query, SpecialtyDocument.class);
		} catch (final MongoException mongoException) {
			mongoException.printStackTrace();

			final var message = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_MESSAGE_WHEN_FIND_BY_NAME);
			final var details = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_DETAILS_WHEN_FIND_BY_NAME);

			throw new DataBaseException(message, details, mongoException.getMessage(), mongoException.getCode());
		}
	}

	@Override
	public void create(final SpecialtyDomain specialtyDomain) {
		try {
			final var specialtyDocument = CreateSpecialtyGateway.mapToSpecialtyDocument(specialtyDomain);

			this.mongoTemplate.save(specialtyDocument);
		} catch (final MongoException mongoException) {
			mongoException.printStackTrace();

			final var message = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_MESSAGE_WHEN_CREATE);
			final var details = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_DETAILS_WHEN_CREATE);

			throw new DataBaseException(message, details, mongoException.getMessage(), mongoException.getCode());
		}
	}

}
