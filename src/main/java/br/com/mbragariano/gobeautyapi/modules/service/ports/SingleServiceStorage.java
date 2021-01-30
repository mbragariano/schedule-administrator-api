package br.com.mbragariano.gobeautyapi.modules.service.ports;

import br.com.mbragariano.gobeautyapi.modules.service.entities.SingleServiceEntity;
import br.com.mbragariano.gobeautyapi.modules.service.persistence.documents.SingleServiceDocument;

import java.util.List;
import java.util.Set;

public interface SingleServiceStorage {

	List<SingleServiceEntity> findByIds(List<String> ids);

	void create(SingleServiceEntity serviceEntity);

}
