package br.com.dreer.core.models.common;

import br.com.dreer.core.enums.AssertsType;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class BaseModelTest<M> {
    protected M model;
    protected String JSON;

    protected abstract void mustReturnSuccessWhenConstructorWithoutParamers();
    protected abstract void mustReturnSuccessWhenConstructorWithAllParameters();
    protected abstract void mustReturnSuccessWhenConstructorWithParameters();
    protected abstract void mustReturnSuccessWhenBuilder();
    protected abstract void mustReturnSuccessWhenToJson() throws JsonProcessingException;
    protected abstract void checkAll(M dto);
    protected abstract void checkWithPartialParameters(M dto);
    protected abstract void checkJSON(String json);
    protected abstract void checkIsInstanceOf(Object object) ;

    public BaseModelTest(M model) {
        this.model = model;
    }


    protected String createMessage(AssertsType message, String field) {
        return String.format(message.getMessage(), field);
    }
}
