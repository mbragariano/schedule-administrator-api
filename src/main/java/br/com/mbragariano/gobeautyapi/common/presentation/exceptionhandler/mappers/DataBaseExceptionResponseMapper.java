package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers;

import br.com.mbragariano.gobeautyapi.common.exceptions.DataBaseException;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.DataBaseExceptionResponse;
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
