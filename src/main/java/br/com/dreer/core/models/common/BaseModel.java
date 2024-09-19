package br.com.dreer.core.models.common;

import br.com.dreer.core.utilitaries.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Objects;

public abstract class BaseModel<T> implements Identifiable {

    private final Class<T> entityClass;

    protected BaseModel(Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass must not be null");
        this.entityClass = entityClass;
    }

    public T toEntity() {
        return Converter.convertTo(this, entityClass);
    }

    public String toJSON() throws JsonProcessingException {
        return Converter.toJSON(this);
    }
}
