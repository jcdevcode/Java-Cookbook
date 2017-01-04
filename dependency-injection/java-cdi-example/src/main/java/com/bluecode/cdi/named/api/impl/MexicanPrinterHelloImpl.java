package com.bluecode.cdi.named.api.impl;

import javax.inject.Named;

import com.bluecode.cdi.named.api.IPrinterHello;
import com.bluecode.cdi.util.Logger;


/**
 * Other implementation for IPrinterHello
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
@Named("MexicanPrinterHelloImpl")
public class MexicanPrinterHelloImpl implements IPrinterHello {
	
	private static final Logger log = Logger.getLogger(MexicanPrinterHelloImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.named.api.IPrinterHello#printHello()
	 */
	public void printHello() {
		log.print("Hola desde: " + MexicanPrinterHelloImpl.class.getSimpleName());

	}

	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.named.api.IPrinterHello#sayHello(java.lang.String)
	 */
	public void sayHello(String name) {
		log.print("Hola: " + name);
	}

}
