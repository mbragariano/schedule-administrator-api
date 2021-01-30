package br.com.mbragariano.gobeautyapi.modules.service.dtos;

import lombok.Builder;

import java.math.BigDecimal;

public class CreateSingleServiceDto extends CreateServiceDto {

	public BigDecimal price;

	public String specialtyName;

	@Builder(builderMethodName = "baseBuilder")
	public CreateSingleServiceDto(final String name, final BigDecimal price, final String specialtyName) {
		super(name);

		this.price = price;
		this.specialtyName = specialtyName;
	}

}
