package com.deximos.mirror_messenger.domain.repository;

import java.util.List;

public interface IGenericRepository<T> {
    public T getById(int id);

    public List<T> list(int start, int limit);

    public void delete(int id);
}
