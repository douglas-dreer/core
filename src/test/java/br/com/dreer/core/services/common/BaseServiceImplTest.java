package br.com.dreer.core.services.common;

public interface BaseServiceImplTest {
    void setUp();

    void mustReturnSuccessWhenListAll();

    void mustReturnBusinessExceptionNotFoundWhenListAll();

    void mustReturnSuccessWhenFindById();

    void mustReturnBusinessExceptionNotFoundWhenFindById();

    void mustReturnSuccessWhenSave();

    void mustReturnBusinessExceptionWhenSave();

    void mustReturnSuccessWhenUpdate();

    void mustReturnBusinessExceptionNotFoundWhenUpdate();

    void mustReturnBusinessExceptionWhenUpdate();

    void mustReturnSuccessWhenDelete();

    void mustReturnBusinessExceptionNotFoundWhenDelete();

    void mustReturnBusinessExceptionWhenDelete();
}
