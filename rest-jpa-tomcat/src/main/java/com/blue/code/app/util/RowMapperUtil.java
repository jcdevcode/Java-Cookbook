package com.blue.code.app.util;

import java.util.ArrayList;
import java.util.List;

import com.blue.code.app.model.dto.TodoDto;
import com.blue.code.app.model.entities.Todo;

/**
 * 
 * @author devcode
 *
 */
public class RowMapperUtil {
	private RowMapperUtil(){		
	}
	
	public static List<TodoDto> todoList2TodoDtoList(List<Todo> lstTodo){
		List<TodoDto> data = null;
		if(lstTodo != null && !lstTodo.isEmpty()){
			data = new ArrayList<TodoDto>();
			for (Todo todo : lstTodo) {
				data.add(todoBean2TodoDto(todo));
			}
		}
		return data;
	}

	public static TodoDto todoBean2TodoDto(Todo todo) {
		TodoDto todoDto = new TodoDto();
		todoDto.setCreated(todo.getCreated());
		todoDto.setDescription(todo.getDescription());
		todoDto.setExpireDate(todo.getExpireDate());
		todoDto.setId(todo.getId());
		todoDto.setTitle(todo.getTitle());
		return todoDto;
	}

	public static Todo todoDto2TodoBean(TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setCreated(todoDto.getCreated());
		todo.setDescription(todoDto.getDescription());
		todo.setExpireDate(todoDto.getExpireDate());
		todo.setId(todoDto.getId());
		todo.setTitle(todoDto.getTitle());
		return todo;
	}
}

