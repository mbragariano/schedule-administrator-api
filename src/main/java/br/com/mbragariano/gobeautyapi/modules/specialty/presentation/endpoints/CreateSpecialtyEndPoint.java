package br.com.mbragariano.gobeautyapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.gobeautyapi.common.annotations.RestEndPoint;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.BaseExceptionResponse;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.EntityValidationExceptionResponse;
import br.com.mbragariano.gobeautyapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.models.requests.CreateSpecialtyRequest;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.presenters.CreateSpecialtyPresenter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestEndPoint
@Api(tags = "Specialty")
@RequiredArgsConstructor
public class CreateSpecialtyEndPoint {

	@Qualifier("createSpecialtyUseCase")
	private final CreateSpecialtyFacade createSpecialtyFacade;

	@PostMapping("/specialty")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(code = 204, value = "Create a specialty")
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Operation successfully executed"),
		@ApiResponse(code = 400, message = "Invalid data", response = EntityValidationExceptionResponse.class),
		@ApiResponse(code = 409, message = "Duplicated Entities", response = BaseExceptionResponse.class),
	})
	public void handle(@RequestBody final CreateSpecialtyRequest createSpecialtyRequest) {
		final var createSpecialtyDto = CreateSpecialtyPresenter.mapToCreateSpecialtyDto(createSpecialtyRequest);

		this.createSpecialtyFacade.execute(createSpecialtyDto);
	}

}
