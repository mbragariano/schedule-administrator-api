package br.com.mbragariano.scheduleadministratorapi.modules.specialty.domains;

import br.com.mbragariano.scheduleadministratorapi.common.domains.BaseDomain;
import br.com.mbragariano.scheduleadministratorapi.common.groups.Create;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialtyDomain extends BaseDomain {

  @NotBlank(groups = Create.class)
  private String name;

  @Builder(builderMethodName = "baseBuilder")
  public SpecialtyDomain(final String id, final String name) {
    super(id);

    this.name = name;
  }

}
