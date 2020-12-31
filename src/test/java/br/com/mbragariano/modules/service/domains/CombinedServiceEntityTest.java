package br.com.mbragariano.modules.service.domains;

import br.com.mbragariano.modules.service.domains.stubs.CombinedServiceEntityTestStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
public class CombinedServiceEntityTest {

	@Test
	public void getPrice_shouldCalculatePrices_expectEqualsToValues() {
		final var combinedServiceEntity = CombinedServiceEntityTestStub.getCombinedServiceEntity();

		final var price = combinedServiceEntity.getPrice();
		final var originPrice = combinedServiceEntity.getOriginPrice();

		assertEquals(price.compareTo(new BigDecimal("46.58")), 0);
		assertEquals(originPrice.compareTo(new BigDecimal("54.80")), 0);
	}

	@Test
	public void getPrice_shouldCalculatePrices_expectNotEqualsToValues() {
		final var combinedServiceEntity = CombinedServiceEntityTestStub.getCombinedServiceEntity();

		final var price = combinedServiceEntity.getPrice();
		final var originPrice = combinedServiceEntity.getOriginPrice();

		assertNotEquals(price.compareTo(new BigDecimal("54.80")), 0);
		assertNotEquals(originPrice.compareTo(new BigDecimal("46.58")), 0);
	}

}
