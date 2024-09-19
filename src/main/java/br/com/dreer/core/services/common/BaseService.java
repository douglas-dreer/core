package br.com.dreer.core.services.common;

import br.com.dreer.core.entities.common.BaseEntity;
import br.com.dreer.core.models.common.BaseModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.UUID;

public interface BaseService<T extends BaseEntity, M extends BaseModel> {
    List<M> listAll();

    M findById(UUID id);

    M save(M model);

    M update(M model) throws JsonProcessingException;

    void delete(UUID id) throws JsonProcessingException;

    void checkIfExists(UUID id);
}
