package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.RestEndPoint;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.models.requests.CreateSpecialtyRequest;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.presenters.CreateSpecialtyPresenter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestEndPoint
@RequiredArgsConstructor
public class CreateSpecialtyRestEndPoint {

	@Qualifier("createSpecialtyUseCase")
	private final CreateSpecialtyFacade createSpecialtyFacade;

	@PostMapping("/specialty")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handle(@RequestBody final CreateSpecialtyRequest createSpecialtyRequest) {
		final var createSpecialtyDto = CreateSpecialtyPresenter.mapToCreateSpecialtyDto(createSpecialtyRequest);

		this.createSpecialtyFacade.execute(createSpecialtyDto);
	}

}
