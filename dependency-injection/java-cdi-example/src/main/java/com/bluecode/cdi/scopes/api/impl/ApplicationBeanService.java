package com.bluecode.cdi.scopes.api.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import com.bluecode.cdi.scopes.api.ISimpleBeanService;
import com.bluecode.cdi.util.Logger;



/**
 * Singleton Bean Implementation.
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
@ApplicationScoped
public class ApplicationBeanService implements ISimpleBeanService {
	
	
	private static final Logger log = Logger.getLogger(ApplicationBeanService.class);
	
	private int numberOfRequest;
	
	@PostConstruct
	public void initBean(){
		log.print("Init bean data");
		numberOfRequest = 0;
	}
	
	@PreDestroy
	public void beforeDestroyBean(){
		log.print("Destroy bean.");
	}
	
	public void doSomething() {
		numberOfRequest++;
		log.print("Number of request: " + numberOfRequest);
	}

	public int getNumberOfRequest() {
		return numberOfRequest;
	}

	public void setNumberOfRequest(int numberOfRequest) {
		this.numberOfRequest = numberOfRequest;
	}
	
	

}
