package com.amk.speedy.guia.ventas.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.amk.speedy.guia.ventas.model.dto.UserDTO;
import com.amk.speedy.guia.ventas.services.IUserService;

@Path("/user")
public class UserServiceRS {
	@EJB
	private IUserService userService;
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO findById(@PathParam("id")Integer id){
		return userService.find(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> findAll(){
		return userService.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO save(UserDTO user){
		return userService.save(user);
	}
	
}
