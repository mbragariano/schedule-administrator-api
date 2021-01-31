package br.com.mbragariano.gobeautyapi.modules.specialty.presentation.endpoints;

import br.com.mbragariano.gobeautyapi.common.annotations.RestEndPoint;
import br.com.mbragariano.gobeautyapi.modules.specialty.facades.FindAllSpecialtiesFacade;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.models.responses.FindAllSpecialtiesResponse;
import br.com.mbragariano.gobeautyapi.modules.specialty.presentation.presenters.FindAllSpecialtiesPresenter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestEndPoint
@Api(tags = "Specialty")
@RequiredArgsConstructor
public class FindAllSpecialtiesEndPoint {

	private final FindAllSpecialtiesFacade findAllSpecialtiesFacade;

	@GetMapping("/specialty")
	@ApiOperation(value = "Find all specialties")
	@ApiResponse(code = 200, message = "Array of specialties", response = FindAllSpecialtiesResponse[].class)
	public ResponseEntity<List<FindAllSpecialtiesResponse>> handle() {
		final var specialtyEntities = this.findAllSpecialtiesFacade.execute();

		return ResponseEntity.ok(FindAllSpecialtiesPresenter.mapToFindAllSpecialtiesResponse(specialtyEntities));
	}

}
