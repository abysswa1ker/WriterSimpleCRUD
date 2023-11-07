package org.Dmytro.repository;

import org.Dmytro.model.Post;

import java.util.List;

public interface GenericRepository <T,ID>{
    T getById(ID id);
    List<T> getAll();
    T save(T t);
    T update(T t);
    Post deleteById(ID id);
}
