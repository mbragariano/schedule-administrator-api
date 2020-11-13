package br.com.mbragariano.common.utils.validation.data;

import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;

import javax.validation.constraints.NotBlank;

public class TokenValidationData {

	@NotBlank(groups = Create.class)
	public String firstHash;

	@NotBlank(groups = Create.class)
	public String secondHash;

	public TokenValidationData(final String firstHash, final String secondHash) {
		this.firstHash = firstHash;
		this.secondHash = secondHash;
	}

}
