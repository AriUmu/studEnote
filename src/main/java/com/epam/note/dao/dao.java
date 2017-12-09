package com.epam.note.dao;

import java.util.List;

public interface dao<T> {

    void  create(T item);

    void update(T item);

    void delete(T item);

    List<T> getAll();

    T getById(long id);
}
