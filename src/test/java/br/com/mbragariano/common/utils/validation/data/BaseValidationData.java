package br.com.mbragariano.common.utils.validation.data;

import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

public class BaseValidationData {

	public List<@Email(groups = Create.class) String> emails;

	public BaseValidationData(
		final List<String> emails
	) {
		this.emails = emails;
	}

}
