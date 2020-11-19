package br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.repositories;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.Adapter;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.DataBaseException;
import br.com.mbragariano.scheduleadministratorapi.common.persistence.gateways.SpecialtyDocumentGateway;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolverPort;
import br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains.SpecialtyDomain;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.documents.SpecialtyDocument;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports.SpecialtyRepositoryPort;
import com.mongodb.MongoException;
import com.mongodb.MongoSocketException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@RequiredArgsConstructor
@Adapter("specialtyMongoDbRepositoryAdapter")
public class SpecialtyMongoDbRepositoryAdapter implements SpecialtyRepositoryPort {

	private final MongoTemplate mongoTemplate;

	private final MessageResolverUtil messageResolverUtil;

	private static final String EXCEPTION_MESSAGE_WHEN_CREATE = "specialty.mongodb.repository.adapter.create.database.exception.message";
	private static final String EXCEPTION_DETAILS_WHEN_CREATE = "specialty.mongodb.repository.adapter.create.database.exception.details";

	private static final String EXCEPTION_MESSAGE_WHEN_FIND_BY_NAME = "specialty.mongodb.repository.adapter.existsByName.database.exception.message";
	private static final String EXCEPTION_DETAILS_WHEN_FIND_BY_NAME = "specialty.mongodb.repository.adapter.existsByName.database.exception.details";

	@Override
	public Boolean existsByName(final String name) {
		try {
			final var query = new Query(Criteria.where("name").is(name));

			return this.mongoTemplate.exists(query, SpecialtyDocument.class);
		} catch (final DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();

			final var message = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_MESSAGE_WHEN_FIND_BY_NAME);
			final var details = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_DETAILS_WHEN_FIND_BY_NAME);

			throw new DataBaseException(message, details, dataAccessException.getMessage(), null);
		}
	}

	@Override
	public void create(final SpecialtyDomain specialtyDomain) {
		try {
			final var specialtyDocument = SpecialtyDocumentGateway.mapToSpecialtyDocument(specialtyDomain);

			this.mongoTemplate.save(specialtyDocument);
		} catch (final MongoException mongoException) {
			mongoException.printStackTrace();

			final var message = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_MESSAGE_WHEN_CREATE);
			final var details = this.messageResolverUtil.resolveMessageWithoutParams(EXCEPTION_DETAILS_WHEN_CREATE);

			throw new DataBaseException(message, details, mongoException.getMessage(), null);
		}
	}

}
