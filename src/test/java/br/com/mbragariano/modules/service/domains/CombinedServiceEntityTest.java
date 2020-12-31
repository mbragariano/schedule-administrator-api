package br.com.mbragariano.modules.service.domains;

import br.com.mbragariano.gobeautyapi.modules.service.entities.CombinedServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.specialty.entities.SpecialtyEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class CombinedServiceEntityTest {

	@Test
	public void getPrice_shouldCalculatePriceWithDiscountPercentage() {
		final var nailSpecialty = new SpecialtyEntity(null, "Nail");

		final var cutHandNails = new SingleServiceEntity(null, "Cut Hand Nails", new BigDecimal("29.90"), nailSpecialty);
		final var cutFootNails = new SingleServiceEntity(null, "Cut Foot Nails", new BigDecimal("24.90"), nailSpecialty);

		final var discountPercentage = new BigDecimal(new BigInteger("15"));

		final var services = List.of(cutFootNails, cutHandNails);
		final var allNailsCombinedService = new CombinedServiceEntity(null, "Cut Nails of Hand and Foot", discountPercentage, services);

		final var price = allNailsCombinedService.getPrice();
		final var originPrice = allNailsCombinedService.getOriginPrice();

		assertEquals(price.compareTo(new BigDecimal("46.58")), 0);
		assertEquals(originPrice.compareTo(new BigDecimal("54.80")), 0);
	}

}
