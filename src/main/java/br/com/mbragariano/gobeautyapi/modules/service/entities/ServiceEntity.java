package br.com.mbragariano.gobeautyapi.modules.service.entities;

import br.com.mbragariano.gobeautyapi.common.entities.BaseEntity;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class ServiceEntity extends BaseEntity {

	@Getter
	@NotBlank(groups = Create.class)
	private String name;

	public abstract BigDecimal getPrice();

	public ServiceEntity(final String id, final String name) {
		super(id);

		this.name = name;
	}

}
