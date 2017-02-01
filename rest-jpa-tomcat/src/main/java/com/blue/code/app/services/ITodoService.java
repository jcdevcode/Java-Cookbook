package com.blue.code.app.services;

import java.util.List;

import com.blue.code.app.model.dto.TodoDto;

/**
 * 
 * @author devcode
 *
 */
public interface ITodoService {
	/**
	 * 
	 * @return
	 */
	public List<TodoDto> findAll();

	/**
	 * 
	 * @param todo
	 * @return
	 */
	public TodoDto create(TodoDto todo);
}
