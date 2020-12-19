package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers;

import br.com.mbragariano.gobeautyapi.common.exceptions.BaseException;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.BaseExceptionResponse;
import org.springframework.http.HttpStatus;

public class BaseExceptionResponseMapper {

	public static BaseExceptionResponse mapToBaseExceptionResponse(
		final BaseException baseException,
		final HttpStatus httpStatus
	) {
			return BaseExceptionResponse.builder()
				.status(httpStatus.value())
				.details(baseException.getDetails())
				.message(baseException.getMessage())
				.exceptionType(baseException.getClass().getSimpleName())
				.developerMessage(baseException.getDeveloperMessage())
				.build();
	}

}
