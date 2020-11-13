package br.com.mbragariano.common.utils.validation.data;

import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class ImplValidationData extends BaseValidationData {

	@NotBlank(groups = Create.class)
	public String name;

	public List<@Valid TokenValidationData> tokens;

	public ImplValidationData(
		final String name,
		final List<String> emails,
		final List<TokenValidationData> tokens
	) {
		super(emails);

		this.name = name;
		this.tokens = tokens;
	}

}
