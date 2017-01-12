package com.amk.sac.consolidate.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amk.sac.consolidate.data.dao.MyDAO;
import com.amk.sac.consolidate.services.ConsolidateService;


@Service
public class ConsolidateServiceImpl implements ConsolidateService {
	private static final Logger logger = LoggerFactory.getLogger(ConsolidateServiceImpl.class);
	
	@Autowired
	private MyDAO myDao;
	
	public void runProcessConsolidate() {
		logger.info("Consolidate Process Service...");
		myDao.save("Test data access.");
	}

}
