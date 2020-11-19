package br.com.mbragariano.scheduleadministratorapi.modules.specialty.persistence.documents;

import br.com.mbragariano.scheduleadministratorapi.common.persistence.documents.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@TypeAlias(SpecialtyDocument.TYPE_ALIAS)
@Document(collection = SpecialtyDocument.COLLECTION_NAME, language = BaseDocument.COLLECTION_DEFAULT_LANGUAGE)
public class SpecialtyDocument extends BaseDocument {

	public static final String TYPE_ALIAS = "specialty";
	public static final String COLLECTION_NAME = "specialties";

	@Field
	public String name;

	@Builder(builderMethodName = "baseBuilder")
	public SpecialtyDocument(final String id, final String name) {
		super(id);

		this.name = name;
	}

}
