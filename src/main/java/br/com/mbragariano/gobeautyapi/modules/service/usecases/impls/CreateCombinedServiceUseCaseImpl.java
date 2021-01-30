package br.com.mbragariano.gobeautyapi.modules.service.usecases.impls;

import br.com.mbragariano.gobeautyapi.common.annotations.UseCase;
import br.com.mbragariano.gobeautyapi.common.exceptions.NotFoundEntityException;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtil;
import br.com.mbragariano.gobeautyapi.common.utils.validation.ValidationUtilMessages;
import br.com.mbragariano.gobeautyapi.modules.service.dtos.CreateCombinedServiceDto;
import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.mappers.CreateCombinedServiceMapper;
import br.com.mbragariano.gobeautyapi.modules.service.ports.CombinedServiceStorage;
import br.com.mbragariano.gobeautyapi.modules.service.ports.SingleServiceStorage;
import br.com.mbragariano.gobeautyapi.modules.service.usecases.interfaces.CreateCombinedServiceUseCase;
import br.com.mbragariano.gobeautyapi.modules.service.validations.ExistServiceByNameValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class CreateCombinedServiceUseCaseImpl implements CreateCombinedServiceUseCase {

	private final ValidationUtil validationUtil;

	@Qualifier("singleServiceMongoDbStorage")
	private final SingleServiceStorage singleServiceStorage;

	@Qualifier("combinedServiceMongoDbStorage")
	private final CombinedServiceStorage combinedServiceStorage;

	private final ExistServiceByNameValidation existServiceByNameValidation;

	private static final String NOT_FOUND_ENTITY_MESSAGE = "Services not found";
	private static final String NOT_FOUND_ENTITY_DETAILS = "Does not exist services with provided ids: ";

	private static final String VALIDATION_ENTITY_MESSAGE = "Invalid values for create service";
	private static final String VALIDATION_ENTITY_DETAILS = "Entered values are invalid for create services, update theirs by validation message and try again";

	@Override
	public void execute(final CreateCombinedServiceDto createCombinedServiceDto) {
		this.existServiceByNameValidation.validate(createCombinedServiceDto.name);

		final var combinedServiceEntity = this.buildCombinedServiceEntity(createCombinedServiceDto);

		this.validationUtil.validate(combinedServiceEntity, this.getValidationUtilMessages(), Create.class);

		this.combinedServiceStorage.create(combinedServiceEntity);
	}

	private CombinedServiceEntity buildCombinedServiceEntity(final CreateCombinedServiceDto createCombinedServiceDto) {
		final var singleServiceEntities = this.findSingleServiceEntitiesByIds(createCombinedServiceDto.serviceIds);

		final var combinedServiceEntity = CreateCombinedServiceMapper.mapToCombinedServiceEntity(createCombinedServiceDto);
		combinedServiceEntity.setSingleServices(singleServiceEntities);

		return combinedServiceEntity;
	}

	private List<SingleServiceEntity> findSingleServiceEntitiesByIds(final List<String> ids) {
		final var singleServiceEntities = this.singleServiceStorage.findByIds(ids);

		if (!Objects.equals(ids.size(), singleServiceEntities.size()))
			this.throwNotFoundEntityException(singleServiceEntities, ids);

		return singleServiceEntities;
	}

	private void throwNotFoundEntityException(
		final List<SingleServiceEntity> singleServiceEntities,
		final List<String> ids
	) {
		final var notFoundIds = this.getNotFoundIds(ids, singleServiceEntities);

		throw new NotFoundEntityException(NOT_FOUND_ENTITY_MESSAGE, NOT_FOUND_ENTITY_DETAILS + notFoundIds, null);
	}

	private List<String> getNotFoundIds(final List<String> ids, final List<SingleServiceEntity> singleServiceEntities) {
		return ids.stream().filter(this.filterByNotFoundIds(singleServiceEntities)).collect(Collectors.toList());
	}

	private Predicate<String> filterByNotFoundIds(final List<SingleServiceEntity> singleServiceEntities) {
		return ids -> singleServiceEntities.stream().map(SingleServiceEntity::getId).noneMatch(ids::contains);
	}

	private ValidationUtilMessages getValidationUtilMessages() {
		return new ValidationUtilMessages(VALIDATION_ENTITY_MESSAGE, VALIDATION_ENTITY_DETAILS);
	}

}
