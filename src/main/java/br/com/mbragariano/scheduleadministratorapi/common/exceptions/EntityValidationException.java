package br.com.mbragariano.scheduleadministratorapi.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
public class EntityValidationException extends BaseException {

	private final Set<EntityValidation> validations;

	@Builder
	@AllArgsConstructor
	public static class EntityValidation {

		public Object value;

		public String message;

		public String relatedWith;

	}

	public EntityValidationException(
		final String message,
		final String details,
		final String developerMessage,
		final Set<EntityValidation> validations
	) {
		super(message, details, developerMessage);

		this.validations = validations;
	}

}
