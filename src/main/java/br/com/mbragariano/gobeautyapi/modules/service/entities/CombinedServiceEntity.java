package br.com.mbragariano.gobeautyapi.modules.service.entities;

import br.com.mbragariano.gobeautyapi.common.groups.Create;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CombinedServiceEntity extends ServiceEntity {

	@NotNull(groups = Create.class)
	@Min(value = 1, groups = Create.class)
	@Max(value = 100, groups = Create.class)
	private BigDecimal discountPercentage;

	@NotEmpty(groups = Create.class)
	private List<SingleServiceEntity> singleServices;

	@Builder
	public CombinedServiceEntity(
		final String id,
		final String name,
		final BigDecimal discountPercentage,
		final List<SingleServiceEntity> singleServices
	) {
		super(id, name);

		this.singleServices = singleServices;
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

}
