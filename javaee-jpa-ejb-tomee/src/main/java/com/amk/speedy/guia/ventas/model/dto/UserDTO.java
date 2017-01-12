package com.amk.speedy.guia.ventas.model.dto;

import java.io.Serializable;


/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 10/01/2017
 * @version 1.0
 */
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 8844545870509996467L;

	private int id;	
	
	private String username;	
	
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
