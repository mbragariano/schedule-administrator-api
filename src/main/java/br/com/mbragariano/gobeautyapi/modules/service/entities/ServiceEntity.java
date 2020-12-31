package br.com.mbragariano.gobeautyapi.modules.service.entities;

import br.com.mbragariano.gobeautyapi.common.entities.BaseEntity;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ServiceEntity extends BaseEntity {

	@NotBlank(groups = Create.class)
	private String name;

	public abstract BigDecimal getPrice();

	public ServiceEntity(final String id, final String name) {
		super(id);

		this.name = name;
	}

}
