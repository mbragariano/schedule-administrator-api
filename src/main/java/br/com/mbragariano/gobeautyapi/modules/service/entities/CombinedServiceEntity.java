package br.com.mbragariano.gobeautyapi.modules.service.entities;

import br.com.mbragariano.gobeautyapi.common.groups.Create;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CombinedServiceEntity extends ServiceEntity {

	@Getter
	@NotNull(groups = Create.class)
	@Positive(groups = Create.class)
	@Max(value = 100, groups = Create.class)
	private BigDecimal discountPercentage;

	@Getter
	private List<SpecialtyEntity> specialties;

	@Getter
	@NotEmpty(groups = Create.class)
	private List<SingleServiceEntity> singleServices;

	@Builder(builderMethodName = "baseBuilder")
	public CombinedServiceEntity(
		final String id,
		final String name,
		final BigDecimal discountPercentage,
		final List<SingleServiceEntity> singleServices
	) {
		super(id, name);

		this.setSingleServices(singleServices);
		this.discountPercentage = discountPercentage;
	}

	@Override
	public BigDecimal getPrice() {
		final var servicePrices = this.getOriginPrice();
		final var discountValue = this.getDiscountValue(servicePrices);

		return servicePrices.subtract(discountValue);
	}

	public BigDecimal getOriginPrice() {
		return this.singleServices.stream().map(SingleServiceEntity::getPrice).reduce(new BigDecimal(0), BigDecimal::add);
	}

	private BigDecimal getDiscountValue(final BigDecimal price) {
		return price.multiply(this.discountPercentage).divide(new BigDecimal(100));
	}

	public void setSingleServices(final List<SingleServiceEntity> singleServices) {
		this.singleServices = singleServices;
		this.setSpecialtiesBySingleServices();
	}

	private void setSpecialtiesBySingleServices() {
		this.specialties = Optional.ofNullable(this.singleServices)
			.map(this.mapSingleServicesToSpecialties())
			.orElse(Collections.emptyList());
	}

	private Function<List<SingleServiceEntity>, List<SpecialtyEntity>> mapSingleServicesToSpecialties() {
		return singleServiceEntities -> singleServiceEntities.stream()
			.map(SingleServiceEntity::getSpecialty)
			.distinct()
			.collect(Collectors.toList());
	}

}
