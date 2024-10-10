package com.deximos.mirror_messenger.domain.repository;

import java.util.List;

public interface IGenericRepository<T> {
    public T getById(int roomId);

    public List<T> list(int start, int limit);

    public void create(T entity);

    public void update(T entity);

    public void delete(int roomId);
}
