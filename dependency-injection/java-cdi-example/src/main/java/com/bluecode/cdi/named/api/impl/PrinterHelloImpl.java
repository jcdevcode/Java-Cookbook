package com.bluecode.cdi.named.api.impl;

import javax.inject.Named;

import com.bluecode.cdi.named.api.IPrinterHello;
import com.bluecode.cdi.util.Logger;

/**
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
@Named("PrinterHelloImpl")
public class PrinterHelloImpl implements IPrinterHello{
	
	private static final Logger log = Logger.getLogger(PrinterHelloImpl.class);
	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.named.api.IPrinterHello#printHello()
	 */
	public void printHello() {
		log.print("Hello from class: " + PrinterHelloImpl.class.getSimpleName());
	}

	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.named.api.IPrinterHello#sayHello(java.lang.String)
	 */
	public void sayHello(String name) {
		log.print("Hello: " + name);		
	}
	
	

}
