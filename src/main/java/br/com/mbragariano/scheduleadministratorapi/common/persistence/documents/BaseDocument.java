package br.com.mbragariano.scheduleadministratorapi.common.persistence.documents;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
public abstract class BaseDocument {

	public static final String COLLECTION_DEFAULT_LANGUAGE = "english";

	@Id
	public String id;

}
