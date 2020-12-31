package br.com.mbragariano.gobeautyapi.modules.service.entities;

import br.com.mbragariano.gobeautyapi.common.groups.Create;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SingleServiceEntity extends ServiceEntity {

	@NotNull(groups = Create.class)
	@Positive(groups = Create.class)
	private BigDecimal price;

	@NotNull(groups = Create.class)
	private SpecialtyEntity specialty;

	@Builder
	public SingleServiceEntity(
		final String id,
		final String name,
		final BigDecimal price,
		final SpecialtyEntity specialty
	) {
		super(id, name);

		this.price = price;
		this.specialty = specialty;
	}

	@Override
	public BigDecimal getPrice() {
		return this.price;
	}

}
