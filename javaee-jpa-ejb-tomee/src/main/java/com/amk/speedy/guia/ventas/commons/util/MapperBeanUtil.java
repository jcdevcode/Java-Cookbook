package com.amk.speedy.guia.ventas.commons.util;

import java.util.ArrayList;
import java.util.List;

import com.amk.speedy.guia.ventas.model.dto.UserDTO;
import com.amk.speedy.guia.ventas.model.entities.User;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 10/01/2017
 * @version 1.0
 */
public class MapperBeanUtil {
	private MapperBeanUtil(){		
	}
	
	public static UserDTO toUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

	public static List<UserDTO> toListUserDto(List<User> users) {
		List<UserDTO> rows = new ArrayList<>();
		UserDTO item = null;
		for (User user : users) {
			item = new UserDTO();
			item.setId(user.getId());
			item.setPassword(user.getPassword());
			item.setUsername(user.getUsername());
			rows.add(item);
		}
		return rows;
	}

	public static User toUserBean(UserDTO user) {
		User row = new User();
		row.setPassword(user.getPassword());
		row.setUsername(user.getUsername());
		return row;
	}
}
