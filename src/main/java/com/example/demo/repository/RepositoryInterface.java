package com.example.demo.repository;

import com.example.demo.model.Rekening;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T> {
    List<T> findAll();
    Optional<T> findOne(Long id);
    T save(T t1);
    void delete(T t1);
}
