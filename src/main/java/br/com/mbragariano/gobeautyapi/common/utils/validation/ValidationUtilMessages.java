package br.com.mbragariano.gobeautyapi.common.utils.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ValidationUtilMessages {

    public String message;

    public String details;

}
