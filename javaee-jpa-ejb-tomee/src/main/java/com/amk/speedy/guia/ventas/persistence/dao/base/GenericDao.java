package com.amk.speedy.guia.ventas.persistence.dao.base;

import java.util.List;


/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 10/01/2017
 * @version 1.0
 * @param <T>
 */
public interface GenericDao<T> {
    
    public T create(T t);

    public void delete(Object id);

    public T find(Object id);

    public T update(T t); 
    
    public List<T> findAll();
}