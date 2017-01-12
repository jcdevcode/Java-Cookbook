package com.blue.code.java.utils.exception;

/**
 * Custom Exception.
 * @author Julio Cesar Bolaños Palacios
 * @since 12/01/2017
 * @version 1.0
 */
public class ZipUtilException extends Exception {
	private static final long serialVersionUID = 4796009078910149659L;
	
	public ZipUtilException(){
		
	}
	public ZipUtilException(String message){
		super(message);
	}

}
