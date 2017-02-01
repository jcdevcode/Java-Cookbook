package com.blue.code.app.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.blue.code.app.model.entities.Todo;
import com.blue.code.app.persistence.config.LocalEntityManagerFactory;
import com.blue.code.app.persistence.dao.ITodoDao;

public class TodoDao implements ITodoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Todo> findAll() {
		List<Todo> rows = null;
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		try{
			rows = em.createQuery("SELECT o FROM Todo AS o").getResultList();
		}catch(Exception e){
			
		}finally {
			em.close();
		}
		return rows;
	}
	
	@Override
	public Todo create(Todo row){
		 EntityManager em = LocalEntityManagerFactory.createEntityManager();
		 try{
			 em.getTransaction().begin();
			 em.persist(row);
			 em.getTransaction().commit();
		 }catch(Exception e){
			 
		 }finally{
			 em.close();
		 }
		 return row;
	}

}
