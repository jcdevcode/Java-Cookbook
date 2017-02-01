package com.blue.code.app.persistence.dao;

import java.util.List;

import com.blue.code.app.model.entities.Todo;

public interface ITodoDao {
	public List<Todo> findAll();
	public Todo create(Todo row);
}
