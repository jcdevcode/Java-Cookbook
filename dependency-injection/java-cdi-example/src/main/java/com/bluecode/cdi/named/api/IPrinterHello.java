package com.bluecode.cdi.named.api;

/**
 * Printer Interface
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public interface IPrinterHello {
	
	
	/**
	 * Print a greeting.
	 */
	public void printHello();
	
	
	/**
	 * Print a personalize greting
	 * @param name
	 */
	public void sayHello(String name);
}
