package br.com.mbragariano.scheduleadministratorapi.common.ports;

import java.util.Locale;

public interface MessageResolver {

	String resolveMessage(String code, Object[] params, Locale locale);

}
