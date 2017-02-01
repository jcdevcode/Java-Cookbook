package com.blue.code.app.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.blue.code.app.model.dto.TodoDto;
import com.blue.code.app.services.ITodoService;

/**
 * Rest Controller ToDo API
 * @author devcode
 *
 */

@Path("/todo")
@ManagedBean
public class TodoController {
	
	@Inject
	ITodoService todoService;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TodoDto> getTodoList(){
		return todoService.findAll();
	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public TodoDto create(TodoDto todo){
		return todoService.create(todo);
	}
	
	@GET
	@Path("/helloTest")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello!!!";
	}
	
}
