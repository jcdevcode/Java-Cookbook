package com.amk.speedy.guia.ventas.persistence.dao;

import javax.ejb.Local;

import com.amk.speedy.guia.ventas.model.entities.User;
import com.amk.speedy.guia.ventas.persistence.dao.base.GenericDao;

@Local
public interface IUserDAO extends GenericDao<User>{

}
