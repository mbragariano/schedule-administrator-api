package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.RestEndPoint;
import br.com.mbragariano.scheduleadministratorapi.common.presentation.models.response.IdResponse;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.model.request.CreateSpecialtyRequest;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.presenters.CreateSpecialtyPresenter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RestEndPoint
@RequiredArgsConstructor
public class CreateSpecialtyRestEndPoint {

	@Qualifier("createSpecialtyUseCase")
	private final CreateSpecialtyFacade createSpecialtyFacade;

	@PostMapping("/specialty")
	public ResponseEntity<IdResponse> handle(@RequestBody final CreateSpecialtyRequest createSpecialtyRequest) {
		final var createdDomainId = this.createSpecialtyFacade.execute(
			CreateSpecialtyPresenter.mapToCreateSpecialtyDto(createSpecialtyRequest)
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(new IdResponse(createdDomainId));
	}

}
