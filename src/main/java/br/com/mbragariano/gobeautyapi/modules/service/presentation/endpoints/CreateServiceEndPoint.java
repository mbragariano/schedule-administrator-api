package br.com.mbragariano.gobeautyapi.modules.service.presentation.endpoints;

import br.com.mbragariano.gobeautyapi.common.annotations.RestEndPoint;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.BaseExceptionResponse;
import br.com.mbragariano.gobeautyapi.common.presentation.exceptionhandler.models.responses.EntityValidationExceptionResponse;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces.CreateServiceHandler;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateServiceRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@RestEndPoint
@Api(tags = "Service")
@RequiredArgsConstructor
public class CreateServiceEndPoint {

	private final List<CreateServiceHandler> createServiceHandlers;

	@PostMapping("/services")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(code = 204, value = "Create a service (single or combined)", notes = "blablablab ablabl")
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Operation successfully executed"),
		@ApiResponse(code = 400, message = "Invalid data", response = EntityValidationExceptionResponse.class),
		@ApiResponse(code = 404, message = "Entities not found", response = BaseExceptionResponse.class),
		@ApiResponse(code = 409, message = "Duplicated entities", response = BaseExceptionResponse.class)
	})
	public void handle(@RequestBody final CreateServiceRequest createServiceRequest) {
		this.createServiceHandlers.stream()
			.filter(this.isTargetInstanceFilter(createServiceRequest))
			.findFirst()
			.orElseThrow(this.getIllegalArgumentExceptionSupplier())
			.handle(createServiceRequest);
	}

	private Supplier<IllegalArgumentException> getIllegalArgumentExceptionSupplier() {
		return () -> new IllegalArgumentException("The request does not match any types: [single, combined]");
	}

	private Predicate<CreateServiceHandler> isTargetInstanceFilter(final CreateServiceRequest createServiceRequest) {
		return createServiceHandler -> createServiceHandler.isTargetInstance(createServiceRequest);
	}

}
