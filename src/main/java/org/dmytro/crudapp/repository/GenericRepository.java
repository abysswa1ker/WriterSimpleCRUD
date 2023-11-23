package org.dmytro.crudapp.repository;

import org.dmytro.crudapp.model.Post;

import java.io.FileNotFoundException;
import java.util.List;

public interface GenericRepository <T,ID>{
    T getById(ID id) throws FileNotFoundException;
    List<T> getAll();
    T save(T t);
    T update(T t);
    void deleteById(ID id);
}
