package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class FindAllSpecialtiesResponse {

	public String id;

	public String name;

}
