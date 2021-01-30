package br.com.mbragariano.gobeautyapi.modules.service.usecases.impls;

import br.com.mbragariano.gobeautyapi.common.annotations.UseCase;
import br.com.mbragariano.gobeautyapi.common.exceptions.NotFoundEntityException;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtil;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtilMessages;
import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateSingleServiceDto;
import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.mappers.CreateSingleServiceMapper;
import br.com.mbragariano.gobeautyapi.modules.service.ports.SingleServiceStorage;
import br.com.mbragariano.gobeautyapi.modules.service.usecases.interfaces.CreateSingleServiceUseCase;
import br.com.mbragariano.gobeautyapi.modules.service.validations.ExistServiceByNameValidation;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.ports.SpecialtyStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@UseCase
@RequiredArgsConstructor
public class CreateSingleServiceUseCaseImpl implements CreateSingleServiceUseCase {

	private final ValidationUtil validationUtil;

	@Qualifier("specialtyMongoDbStorage")
	private final SpecialtyStorage specialtyStorage;

	@Qualifier("singleServiceMongoDbStorage")
	private final SingleServiceStorage singleServiceStorage;

	private final ExistServiceByNameValidation existServiceByNameValidation;

	private static final String NOT_FOUND_ENTITY_MESSAGE = "Specialty not found";
	private static final String NOT_FOUND_ENTITY_DETAILS = "Does not exist specialty with provided name";

	private static final String VALIDATION_ENTITY_MESSAGE = "Invalid values for create service";
	private static final String VALIDATION_ENTITY_DETAILS = "Entered values are invalid for create services, update theirs by validation message and try again";

	@Override
	public void execute(final CreateSingleServiceDto createSingleServiceDto) {
		this.existServiceByNameValidation.validate(createSingleServiceDto.name);

		final var singleServiceEntity = this.buildSingleServiceEntity(createSingleServiceDto);

		this.validationUtil.validate(singleServiceEntity, this.getValidationUtilMessages(), Create.class);

		this.singleServiceStorage.create(singleServiceEntity);
	}

	private SingleServiceEntity buildSingleServiceEntity(final CreateSingleServiceDto createSingleServiceDto) {
		final var specialtyEntity = this.findSpecialtyByName(createSingleServiceDto.specialtyName);

		final var singleServiceEntity = CreateSingleServiceMapper.mapToSingleServiceEntity(createSingleServiceDto);
		singleServiceEntity.setSpecialty(specialtyEntity);

		return singleServiceEntity;
	}

	private SpecialtyEntity findSpecialtyByName(final String name) {
		final var specialtyEntity = this.specialtyStorage.findByName(name);

		if (specialtyEntity.isEmpty())
			throw new NotFoundEntityException(NOT_FOUND_ENTITY_MESSAGE, NOT_FOUND_ENTITY_DETAILS, null);

		return specialtyEntity.get();
	}

	private ValidationUtilMessages getValidationUtilMessages() {
		return new ValidationUtilMessages(VALIDATION_ENTITY_MESSAGE, VALIDATION_ENTITY_DETAILS);
	}

}
