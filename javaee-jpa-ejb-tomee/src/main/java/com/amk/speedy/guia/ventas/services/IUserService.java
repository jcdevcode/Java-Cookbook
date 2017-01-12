package com.amk.speedy.guia.ventas.services;

import java.util.List;

import javax.ejb.Local;

import com.amk.speedy.guia.ventas.model.dto.UserDTO;


@Local
public interface IUserService {
	
	/**
	 * 
	 * @param user
	 */
	public UserDTO save(UserDTO user);
	
	
	/**
	 * 
	 * @return
	 */
	public List<UserDTO> findAll();


	/**
	 * 
	 * @param id
	 * @return
	 */
	public UserDTO find(Integer id);
}
