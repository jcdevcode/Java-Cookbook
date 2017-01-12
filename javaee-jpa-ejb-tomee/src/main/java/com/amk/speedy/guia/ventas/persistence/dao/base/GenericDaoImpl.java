package com.amk.speedy.guia.ventas.persistence.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 10/01/2017
 * @version 1.0
 * @param <T>
 * @param <PK>
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    
    @Override
    public T create(final T t) {
        this.em.persist(t);
        this.em.flush();
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);    
    }
    
    @Override
    @SuppressWarnings("unchecked")
	public List<T> findAll(){
    	return this.em.createQuery("SELECT o FROM " + this.type.getSimpleName()+ " As o ").getResultList();
    }
}