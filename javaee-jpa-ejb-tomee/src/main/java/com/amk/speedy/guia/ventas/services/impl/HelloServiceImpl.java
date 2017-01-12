package com.amk.speedy.guia.ventas.services.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amk.speedy.guia.ventas.persistence.dao.IHelloDAO;
import com.amk.speedy.guia.ventas.services.IHelloService;


@Stateless
@LocalBean
public class HelloServiceImpl implements IHelloService {
	
	private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	@EJB
	private IHelloDAO helloDao;

	@Override
	public String sayHello() {
		log.info("In: HelloServiceImpl -> sayHello.");
		return helloDao.sayHello();
	}

}
