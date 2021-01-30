package br.com.mbragariano.gobeautyapi.modules.service.presentation.endpoints;

import br.com.mbragariano.gobeautyapi.common.annotations.RestEndPoint;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.handlers.interfaces.CreateServiceHandler;
import br.com.mbragariano.gobeautyapi.modules.service.presentation.models.request.CreateServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@RestEndPoint
@RequiredArgsConstructor
public class CreateServiceRestEndPoint {

	private final List<CreateServiceHandler> createServiceHandlers;

	@PostMapping("/services")
	@ResponseStatus(HttpStatus.NO_CONTENT)
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
