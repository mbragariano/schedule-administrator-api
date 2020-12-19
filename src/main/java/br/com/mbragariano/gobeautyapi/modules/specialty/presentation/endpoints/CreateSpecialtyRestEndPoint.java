package br.com.mbragariano.gobeautyapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.gobeautyapi.common.annotations.RestEndPoint;
import br.com.mbragariano.gobeautyapi.modules.specialty.facades.CreateSpecialtyFacade;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.models.requests.CreateSpecialtyRequest;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.presenters.CreateSpecialtyPresenter;
import lombok.RequiredArgsConstructor;
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
