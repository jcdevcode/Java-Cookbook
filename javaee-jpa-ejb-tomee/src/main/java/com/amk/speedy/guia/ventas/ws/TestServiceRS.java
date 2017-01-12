package com.amk.speedy.guia.ventas.ws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amk.speedy.guia.ventas.services.IHelloService;

@Path("/test")
public class TestServiceRS {
	
	private static final Logger log = LoggerFactory.getLogger(TestServiceRS.class);
	
	@EJB
	private IHelloService helloService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		log.info("In: TestServiceRS -> sayHello.");
		return helloService.sayHello();
	}
}
