package br.com.mbragariano.scheduleadministratorapi.common.exceptions;

import lombok.Getter;

@Getter
public class DataBaseException extends BaseException {

	private final Integer errorCode;

	public DataBaseException(final String message, final String details, final String developerMessage, final Integer errorCode) {
		super(message, details, developerMessage);

		this.errorCode = errorCode;
	}

}
