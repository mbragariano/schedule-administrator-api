package br.com.mbragariano.scheduleadministratorapi.common.exceptions;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {

	private final String details;

	private final String developerMessage;

	public BaseException(final String message, final String details, final String developerMessage) {
		super(message);

		this.details = details;
		this.developerMessage = developerMessage;
	}

}
