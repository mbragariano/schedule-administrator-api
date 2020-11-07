package br.com.mbragariano.scheduleadministratorapi.common.exceptions;

public class DuplicatedEntityException extends BaseException {

	public DuplicatedEntityException(final String message, final String details, final String developerMessage) {
		super(message, details, developerMessage);
	}

}
