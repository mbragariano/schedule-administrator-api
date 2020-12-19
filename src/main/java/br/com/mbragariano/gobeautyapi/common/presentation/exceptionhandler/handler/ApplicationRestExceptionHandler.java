package br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.handler;

import br.com.mbragariano.gobeautyapi.common.exceptions.DataBaseException;
import br.com.mbragariano.gobeautyapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.gobeautyapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.gobeautyapi.common.exceptions.NotFoundEntityException;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers.BaseExceptionResponseMapper;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers.DataBaseExceptionResponseMapper;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.mappers.EntityValidationExceptionResponseMapper;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.BaseExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<BaseExceptionResponse> handleDataBaseException(final DataBaseException duplicatedEntityException) {
		final var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		return ResponseEntity.status(httpStatus)
			.body(DataBaseExceptionResponseMapper.mapToDataBaseExceptionResponse(duplicatedEntityException, httpStatus));
	}

	@ExceptionHandler(DuplicatedEntityException.class)
	public ResponseEntity<BaseExceptionResponse> handleDuplicatedEntityException(final DuplicatedEntityException duplicatedEntityException) {
		final var httpStatus = HttpStatus.CONFLICT;

		return ResponseEntity.status(httpStatus)
			.body(BaseExceptionResponseMapper.mapToBaseExceptionResponse(duplicatedEntityException, httpStatus));
	}

	@ExceptionHandler(EntityValidationException.class)
	public ResponseEntity<BaseExceptionResponse> handleEntityValidationException(final EntityValidationException duplicatedEntityException) {
		final var httpStatus = HttpStatus.BAD_REQUEST;

		return ResponseEntity.status(httpStatus)
			.body(EntityValidationExceptionResponseMapper.mapToEntityValidationExceptionResponse(duplicatedEntityException, httpStatus));
	}

	@ExceptionHandler(NotFoundEntityException.class)
	public ResponseEntity<BaseExceptionResponse> handleNotFoundEntityException(final NotFoundEntityException notFoundEntityException) {
		final var httpStatus = HttpStatus.NOT_FOUND;

		return ResponseEntity.status(httpStatus)
			.body(BaseExceptionResponseMapper.mapToBaseExceptionResponse(notFoundEntityException, httpStatus));
	}

}
