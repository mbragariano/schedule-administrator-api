package br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.mappers;

import br.com.mbragariano.scheduleadministratorapi.common.exceptions.DataBaseException;
import br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.model.response.DataBaseExceptionResponse;
import org.springframework.http.HttpStatus;

public class DataBaseExceptionResponseMapper {

	public static DataBaseExceptionResponse mapToDataBaseExceptionResponse(
		final DataBaseException dataBaseException,
		final HttpStatus httpStatus
	) {
		return DataBaseExceptionResponse.inheritanceBuilde()
			.errorCode(dataBaseException.getErrorCode())
			.details(dataBaseException.getDetails())
			.message(dataBaseException.getMessage())
			.developerMessage(dataBaseException.getDeveloperMessage())
			.exceptionType(dataBaseException.getClass().getSimpleName())
			.status(httpStatus.value())
			.build();
	}

}
