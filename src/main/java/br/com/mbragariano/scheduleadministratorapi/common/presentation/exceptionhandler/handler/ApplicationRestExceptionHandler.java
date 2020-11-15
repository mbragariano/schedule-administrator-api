package br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.handler;

import br.com.mbragariano.scheduleadministratorapi.common.exceptions.DuplicatedEntityException;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.EntityValidationException;
import br.com.mbragariano.scheduleadministratorapi.common.exceptions.NotFoundEntityException;
import br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.mappers.BaseExceptionResponseMapper;
import br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.mappers.EntityValidationExceptionResponseMapper;
import br.com.mbragariano.scheduleadministratorapi.common.presentation.exceptionhandler.model.response.BaseExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationRestExceptionHandler extends ResponseEntityExceptionHandler {

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
