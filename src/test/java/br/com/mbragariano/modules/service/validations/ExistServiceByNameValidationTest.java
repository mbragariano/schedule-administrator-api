package br.com.mbragariano.modules.service.validations;

import br.com.mbragariano.gobeautyapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.gobeautyapi.modules.service.ports.ServiceStorage;
import br.com.mbragariano.gobeautyapi.modules.service.validations.ExistServiceByNameValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ExistServiceByNameValidationTest {

	@Mock
	private ServiceStorage serviceStorage;

	@InjectMocks
	private ExistServiceByNameValidation existServiceByNameValidation;

	@Test
	public void validate_shouldThrowDuplicatedEntityException_whenExistsStorageByName() {
		doReturn(Boolean.TRUE).when(this.serviceStorage).existsByName(anyString());

		assertThrows(DuplicatedEntityException.class, this.getExecutable());
	}

	@Test
	public void validate_shouldNotThrowDuplicatedEntityException_whenNotExistsStorageByName() {
		doReturn(Boolean.FALSE).when(this.serviceStorage).existsByName(anyString());

		assertDoesNotThrow(this.getExecutable());
	}

	private Executable getExecutable() {
		return () -> this.existServiceByNameValidation.validate("Hair");
	}

}
