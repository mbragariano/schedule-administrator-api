package br.com.mbragariano.gobeautyapi.modules.specialty.usecases;

import br.com.mbragariano.gobeautyapi.common.annotations.UseCase;
import br.com.mbragariano.gobeautyapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import br.com.mbragariano.gobeautyapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtil;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtilMessages;
import br.com.mbragariano.gobeautyapi.modules.specialty.dtos.CreateSpecialtyDto;
import br.com.mbragariano.gobeautyapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.gobeautyapi.modules.specialty.mappers.CreateSpecialtyMapper;
import br.com.mbragariano.gobeautyapi.modules.specialty.ports.SpecialtyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@UseCase
@RequiredArgsConstructor
public class CreateSpecialtyUseCase implements CreateSpecialtyFacade {

	private final ValidationUtil validationUtil;

	@Qualifier("specialtyMongoDbStorage")
	private final SpecialtyStorage specialtyStorage;

	private final MessageResolverUtil messageResolverUtil;

	private final String VALIDATION_MESSAGE_CODE = "create-specialty-facade.entity-validation-exception.message";
	private final String VALIDATION_DETAILS_CODE = "create-specialty-facade.entity-validation-exception.details";

	private final String DUPLICATED_ENTITY_EXCEPTION_MESSAGE_CODE = "create-specialty-facade.duplicated-entity-exception.message";
	private final String DUPLICATED_ENTITY_EXCEPTION_DETAILS_CODE = "create-specialty-facade.duplicated-entity-exception.details";

	@Override
	public void execute(final CreateSpecialtyDto createSpecialtyDto) {
		final var existsByName = this.specialtyStorage.existsByName(createSpecialtyDto.name);

		if (existsByName)
			throw new DuplicatedEntityException(
				this.messageResolverUtil.resolveMessageWithoutParams(DUPLICATED_ENTITY_EXCEPTION_MESSAGE_CODE),
				this.messageResolverUtil.resolveMessageWithoutParams(DUPLICATED_ENTITY_EXCEPTION_DETAILS_CODE),
				null
			);

		final var specialtyEntity = CreateSpecialtyMapper.mapToSpecialtyEntity(createSpecialtyDto);

		this.validationUtil.validate(specialtyEntity, new ValidationUtilMessages(VALIDATION_MESSAGE_CODE, VALIDATION_DETAILS_CODE), Create.class);

		this.specialtyStorage.create(specialtyEntity);
	}

}
