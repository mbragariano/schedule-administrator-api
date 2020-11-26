package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.scheduleadministratorapi.common.annotations.RestEndPoint;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.facades.FindAllSpecialtiesFacade;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.models.responses.FindAllSpecialtiesResponse;
import br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.presenters.FindAllSpecialtiesPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestEndPoint
@RequiredArgsConstructor
public class FindAllSpecialtiesEndPoint {

	private final FindAllSpecialtiesFacade findAllSpecialtiesFacade;

	@GetMapping("/specialty")
	public ResponseEntity<List<FindAllSpecialtiesResponse>> handle() {
		final var specialtyDomains = this.findAllSpecialtiesFacade.execute();

		return ResponseEntity.ok(FindAllSpecialtiesPresenter.mapToFindAllSpecialtiesResponse(specialtyDomains));
	}

}
