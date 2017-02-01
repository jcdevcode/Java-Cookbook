package com.blue.code.app.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.blue.code.app.model.dto.TodoDto;
import com.blue.code.app.model.entities.Todo;
import com.blue.code.app.persistence.dao.ITodoDao;
import com.blue.code.app.services.ITodoService;
import com.blue.code.app.util.RowMapperUtil;

/**
 * 
 * @author devcode
 *
 */
public class TodoService implements ITodoService{
	
	@Inject
	ITodoDao todoDao;

	@Override
	public List<TodoDto> findAll() {
		return RowMapperUtil.todoList2TodoDtoList(todoDao.findAll());
	}

	@Override
	public TodoDto create(TodoDto todo) {
		todo.setCreated(new Date());
		Todo row = todoDao.create(RowMapperUtil.todoDto2TodoBean(todo));
		return RowMapperUtil.todoBean2TodoDto(row);
	}

}
