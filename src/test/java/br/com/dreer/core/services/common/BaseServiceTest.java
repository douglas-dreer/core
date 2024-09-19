package br.com.dreer.core.services.common;

import br.com.dreer.core.utilitaries.InformationGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public abstract class BaseServiceTest<M, E, S, R> extends InformationGenerator implements BaseServiceImplTest {

    protected final UUID id = UUID.randomUUID();
    @Autowired
    public S service;
    protected M model;
    protected E entity;
    protected List<E> resultList = new ArrayList<>();
    protected E result;
    protected Optional<E> optional = Optional.empty();
    protected Optional<E> optinalEmpty = Optional.empty();
    protected List<E> listEmpty = new ArrayList<>();
    @MockBean
    protected R repository;
}


