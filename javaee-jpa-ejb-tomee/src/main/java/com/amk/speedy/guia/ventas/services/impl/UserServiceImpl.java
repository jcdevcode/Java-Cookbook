package com.amk.speedy.guia.ventas.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.amk.speedy.guia.ventas.commons.util.MapperBeanUtil;
import com.amk.speedy.guia.ventas.model.dto.UserDTO;
import com.amk.speedy.guia.ventas.model.entities.User;
import com.amk.speedy.guia.ventas.persistence.dao.IUserDAO;
import com.amk.speedy.guia.ventas.services.IUserService;


@Stateless
@LocalBean
public class UserServiceImpl implements IUserService {
	
	@EJB
	private IUserDAO userDao;

	@Override
	public UserDTO save(UserDTO user) {		
		User newUserRow = userDao.create(MapperBeanUtil.toUserBean(user));
		return MapperBeanUtil.toUserDto(newUserRow);
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> users = userDao.findAll();
		if(users != null){
			return MapperBeanUtil.toListUserDto(users);
		}
		return null;
	}

	@Override
	public UserDTO find(Integer id) {
		User user = userDao.find(id);
		if(user != null){			
			return MapperBeanUtil.toUserDto(user);
		}
		return null;
	}

	

}
