package com.example.vejret.services;

import java.util.List;

/*
interface til alle services
 */
public interface IService<E> {

    List<E> findAll();
    void save(E e);

}
