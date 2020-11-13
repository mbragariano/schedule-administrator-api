package br.com.mbragariano.scheduleadministratorapi.common.utils.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ValidationUtilMessages {

    public String message;

    public String details;

    public String developerMessage;

}
