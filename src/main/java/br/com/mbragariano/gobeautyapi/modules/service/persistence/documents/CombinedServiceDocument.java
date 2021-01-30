package br.com.mbragariano.gobeautyapi.modules.service.persistence.documents;

import br.com.mbragariano.gobeautyapi.common.persistence.documents.BaseDocument;
import br.com.mbragariano.gobeautyapi.modules.specialty.persistence.documents.SpecialtyDocument;
import lombok.Builder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.util.List;

@TypeAlias(CombinedServiceDocument.TYPE_ALIAS)
@Document(collection = ServiceDocument.COLLECTION_NAME, language = BaseDocument.COLLECTION_DEFAULT_LANGUAGE)
public class CombinedServiceDocument extends ServiceDocument {

	public static final String TYPE_ALIAS = "combinedService";

	@Field(targetType = FieldType.DECIMAL128)
	public BigDecimal discountPercentage;

	@Field
	@DBRef(lazy = true)
	public List<SpecialtyDocument> specialties;

	@Field
	@DBRef(lazy = true)
	public List<SingleServiceDocument> singleServices;

	@Builder(builderMethodName = "baseBuilder")
	public CombinedServiceDocument(
		final String id,
		final String name,
		final BigDecimal discountPercentage,
		final List<SpecialtyDocument> specialties,
		final List<SingleServiceDocument> singleServices
	) {
		super(id, name);

		this.specialties = specialties;
		this.singleServices = singleServices;
		this.discountPercentage = discountPercentage;
	}

}
