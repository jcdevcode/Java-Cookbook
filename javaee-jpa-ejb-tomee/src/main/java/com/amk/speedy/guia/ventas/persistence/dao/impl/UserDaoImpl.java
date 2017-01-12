package com.amk.speedy.guia.ventas.persistence.dao.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.amk.speedy.guia.ventas.model.entities.User;
import com.amk.speedy.guia.ventas.persistence.dao.IUserDAO;
import com.amk.speedy.guia.ventas.persistence.dao.base.GenericDaoImpl;

@Stateless
@LocalBean
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDAO{

}
