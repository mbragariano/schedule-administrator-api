package br.com.mbragariano.common.utils.validation;

import br.com.mbragariano.common.utils.validation.configuration.MessageResolverPortTestConfiguration;
import br.com.mbragariano.common.utils.validation.data.ImplValidationData;
import br.com.mbragariano.common.utils.validation.data.TokenValidationData;
import br.com.mbragariano.scheduleadministratorapi.common.configurations.MessageSourceConfiguration;
import br.com.mbragariano.scheduleadministratorapi.common.configurations.ValidatorConfiguration;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;
import br.com.mbragariano.scheduleadministratorapi.common.ports.MessageResolver;
import br.com.mbragariano.scheduleadministratorapi.common.utils.messageresolver.MessageResolverUtil;
import br.com.mbragariano.scheduleadministratorapi.common.utils.validation.ValidationUtil;
import br.com.mbragariano.scheduleadministratorapi.common.utils.validation.ValidationUtilMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Validator;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
	MessageResolverPortTestConfiguration.class,
	MessageSourceConfiguration.class,
	ValidatorConfiguration.class
})
public class ValidationUtilTest {

	@Autowired
	private Validator validator;

	@Autowired
	private MessageResolverUtil messageResolverUtil;

	private ValidationUtil validationUtil;

	@BeforeEach
	public void beforeEach() {
		this.validationUtil = new ValidationUtil(this.validator, this.messageResolverUtil);
	}

	@Test
	public void validate_shouldNotThrowEntityValidationException_whenObjectIsValid() {
		final var emails = Arrays.asList("first@example.com", "sencond@example.com");
		final var tokens = Arrays.asList(
			new TokenValidationData("a1b2c3", "d4e5f6"),
			new TokenValidationData("1a2bc3", "4d5e6f")
		);

		final var data = new ImplValidationData("Matheus", emails, tokens);
		final var messages = new ValidationUtilMessages("Cannot create data", "See messages and try again");

		assertDoesNotThrow(() -> this.validationUtil.validate(data, messages));
	}

	@Test
	public void validate_shouldThrowEntityValidationException_whenObjectIsInvalid() {
		final var emails = Arrays.asList("", "");
		final var tokens = Arrays.asList(new TokenValidationData("", ""), new TokenValidationData("", ""));

		final var data = new ImplValidationData("", emails, tokens);
		final var messages = new ValidationUtilMessages("Cannot create data", "See messages and try again");

		assertThrows(EntityValidationException.class,
			() -> this.validationUtil.validate(data, messages, Create.class));
	}

}
