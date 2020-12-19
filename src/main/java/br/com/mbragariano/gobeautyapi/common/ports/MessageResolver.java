package br.com.mbragariano.gobeautyapi.common.ports;

import java.util.Locale;

public interface MessageResolver {

	String resolveMessage(String code, Object[] params, Locale locale);

}
