package com.bluecode.cdi.util;


/**
 * Custom Logger, not use in real project.
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public class Logger {
	private String className;
	
	public Logger(String className){
		this.className = className;
	}
	
	
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class classRef){
		String className = classRef.getName();
		
		return new Logger(className);
	}
	
	public void print(String message){
		System.out.println("[" + this.className +"] " + message);
	}
	
	
	
	
}
