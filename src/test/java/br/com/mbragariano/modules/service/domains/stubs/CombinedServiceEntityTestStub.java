package br.com.mbragariano.modules.service.domains.stubs;

import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;

import java.math.BigDecimal;
import java.util.List;

public class CombinedServiceEntityTestStub {

	public static CombinedServiceEntity getCombinedServiceEntity() {
		return CombinedServiceEntity.baseBuilder()
			.name("Cut Hand Nails + Cut Foot Nails")
			.discountPercentage(new BigDecimal("15"))
			.singleServices(getSingleServiceEntities())
			.build();
	}

	private static List<SingleServiceEntity> getSingleServiceEntities() {
		return List.of(getFirstSingleServiceEntity(), getSecondSingleServiceEntity());
	}

	private static SingleServiceEntity getFirstSingleServiceEntity() {
		return SingleServiceEntity.baseBuilder()
			.name("Cut Hand Nails")
			.price(new BigDecimal("29.90"))
			.specialty(getSpecialtyEntity())
			.build();
	}

	private static SingleServiceEntity getSecondSingleServiceEntity() {
		return SingleServiceEntity.baseBuilder()
			.name("Cut Foot Nails")
			.price(new BigDecimal("24.90"))
			.specialty(getSpecialtyEntity())
			.build();
	}

	private static SpecialtyEntity getSpecialtyEntity() {
		return SpecialtyEntity.baseBuilder().name("Nail").build();
	}

}
