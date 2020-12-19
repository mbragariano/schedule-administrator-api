package br.com.mbragariano.gobeautyapi.modules.specialty.entities;

import br.com.mbragariano.gobeautyapi.common.entities.BaseEntity;
import br.com.mbragariano.gobeautyapi.common.groups.Create;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialtyEntity extends BaseEntity {

  @NotBlank(groups = Create.class)
  private String name;

  @Builder(builderMethodName = "baseBuilder")
  public SpecialtyEntity(final String id, final String name) {
    super(id);

    this.name = name;
  }

}
