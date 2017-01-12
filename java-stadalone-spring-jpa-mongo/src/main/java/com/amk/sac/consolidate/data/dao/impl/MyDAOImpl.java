package com.amk.sac.consolidate.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.amk.sac.consolidate.data.dao.MyDAO;

@Repository
public class MyDAOImpl implements MyDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(MyDAOImpl.class);

	public void save(String data) {
		logger.info("Save data: {} ", data );
		
	}

}
