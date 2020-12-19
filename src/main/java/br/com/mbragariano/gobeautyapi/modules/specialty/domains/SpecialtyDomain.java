package br.com.mbragariano.gobeautyapi.modules.specialty.domains;

import br.com.mbragariano.gobeautyapi.common.domains.BaseDomain;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
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
