package br.com.mbragariano.scheduleadministratorapi.modules.specialty.presentation.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecialtyRequest {

	public String name;

}
