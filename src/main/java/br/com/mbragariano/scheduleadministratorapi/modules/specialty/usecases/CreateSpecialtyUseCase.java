package br.com.mbragariano.scheduleadministratorapi.modules.specialty.usecases;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.UseCase;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;
import br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.scheduleadministratorapi.common.utils.validation.ValidationUtil;
import br.com.mbragariano.scheduleadministratorapi.common.utils.validation.ValidationUtilMessages;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.dtos.CreateSpecialtyDto;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.mappers.CreateSpecialtyMapper;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.ports.SpecialtyRepositoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@UseCase
@RequiredArgsConstructor
public class CreateSpecialtyUseCase implements CreateSpecialtyFacade {

	private final ValidationUtil validationUtil;

	private final MessageResolverUtil messageResolverUtil;

	@Qualifier("specialtyMongoDbRepositoryAdapter")
	private final SpecialtyRepositoryStorage specialtyRepositoryStorage;

	private final String VALIDATION_MESSAGE_CODE = "create-specialty-facade.entity-validation-exception.message";
	private final String VALIDATION_DETAILS_CODE = "create-specialty-facade.entity-validation-exception.details";

	private final String DUPLICATED_ENTITY_EXCEPTION_MESSAGE_CODE = "create-specialty-facade.duplicated-entity-exception.message";
	private final String DUPLICATED_ENTITY_EXCEPTION_DETAILS_CODE = "create-specialty-facade.duplicated-entity-exception.details";

	@Override
	public void execute(final CreateSpecialtyDto createSpecialtyDto) {
		final var existsByName = this.specialtyRepositoryStorage.existsByName(createSpecialtyDto.name);

		if (existsByName)
			throw new DuplicatedEntityException(
				this.messageResolverUtil.resolveMessageWithoutParams(DUPLICATED_ENTITY_EXCEPTION_MESSAGE_CODE),
				this.messageResolverUtil.resolveMessageWithoutParams(DUPLICATED_ENTITY_EXCEPTION_DETAILS_CODE),
				null
			);

		final var specialtyDomain = CreateSpecialtyMapper.mapToSpecialtyDomain(createSpecialtyDto);

		this.validationUtil.validate(specialtyDomain, new ValidationUtilMessages(VALIDATION_MESSAGE_CODE, VALIDATION_DETAILS_CODE), Create.class);

		this.specialtyRepositoryStorage.create(specialtyDomain);
	}

}
