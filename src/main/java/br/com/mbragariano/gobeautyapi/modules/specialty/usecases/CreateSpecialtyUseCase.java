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

	private final String VALIDATION_MESSAGE = "Cannot create specialty";
	private final String VALIDATION_DETAILS = "Entered values are invalid, update theirs by validation message and try again";

	private final String DUPLICATED_ENTITY_MESSAGE = "Duplicated specialty by name";
	private final String DUPLICATED_ENTITY_DETAILS = "There is already a specialty registered with that name";

	@Override
	public void execute(final CreateSpecialtyDto createSpecialtyDto) {
		final var existsByName = this.specialtyStorage.existsByName(createSpecialtyDto.name);

		if (existsByName)
			throw new DuplicatedEntityException(DUPLICATED_ENTITY_MESSAGE, DUPLICATED_ENTITY_DETAILS, null);

		final var specialtyEntity = CreateSpecialtyMapper.mapToSpecialtyEntity(createSpecialtyDto);

		this.validationUtil.validate(specialtyEntity, this.getValidationUtilMessages(), Create.class);

		this.specialtyStorage.create(specialtyEntity);
	}

	private ValidationUtilMessages getValidationUtilMessages() {
		return new ValidationUtilMessages(VALIDATION_MESSAGE, VALIDATION_DETAILS);
	}

}
