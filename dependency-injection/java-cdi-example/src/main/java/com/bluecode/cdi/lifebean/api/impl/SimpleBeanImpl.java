package com.bluecode.cdi.lifebean.api.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.bluecode.cdi.lifebean.api.ISimpleBean;
import com.bluecode.cdi.util.Logger;

/**
 * Implementation
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public class SimpleBeanImpl implements ISimpleBean {
	private static final Logger log = Logger.getLogger(SimpleBeanImpl.class);
	
	@PostConstruct
	public void initMyLife(){
		log.print("After create instance of: " + SimpleBeanImpl.class.getName());
	}
	
	public void doSomething() {
		log.print("Something...");
	}
	
	@PreDestroy
	public void endMyLife(){
		log.print("Before destroy instance of: " + SimpleBeanImpl.class.getName());
	}

}
