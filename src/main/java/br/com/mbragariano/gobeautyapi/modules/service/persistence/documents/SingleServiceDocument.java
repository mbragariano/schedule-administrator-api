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

@TypeAlias(SingleServiceDocument.TYPE_ALIAS)
public class SingleServiceDocument extends ServiceDocument {

	public static final String TYPE_ALIAS = "singleService";

	@Field(targetType = FieldType.DECIMAL128)
	public BigDecimal price;

	@Field
	@DBRef(lazy = true)
	public SpecialtyDocument specialty;

	@Builder(builderMethodName = "baseBuilder")
	public SingleServiceDocument(
		final String id,
		final String name,
		final BigDecimal price,
		final SpecialtyDocument specialty
	) {
		super(id, name);

		this.price = price;
		this.specialty = specialty;
	}

}
