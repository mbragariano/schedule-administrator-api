package br.com.mbragariano.gobeautyapi.modules.service.persistence.documents;

import br.com.mbragariano.gobeautyapi.common.persistence.documents.BaseDocument;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = ServiceDocument.COLLECTION_NAME, language = BaseDocument.COLLECTION_DEFAULT_LANGUAGE)
public abstract class ServiceDocument extends BaseDocument {

	public static final String COLLECTION_NAME = "services";

	@Field
	@Indexed(unique = true)
	public String name;

	public ServiceDocument(final String id, final String name) {
		super(id);

		this.name = name;
	}

}
