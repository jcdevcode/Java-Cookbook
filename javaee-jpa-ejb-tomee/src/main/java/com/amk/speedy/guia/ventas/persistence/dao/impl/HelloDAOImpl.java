package com.amk.speedy.guia.ventas.persistence.dao.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amk.speedy.guia.ventas.persistence.dao.IHelloDAO;


@Stateless
@LocalBean
public class HelloDAOImpl implements IHelloDAO {
	
	private static final Logger log = LoggerFactory.getLogger(HelloDAOImpl.class);
	
	@Override
	public String sayHello() {
		log.info("In: HelloDAOImpl -> sayHello");
		return "Hello World from Dao!!!";
	}

}
