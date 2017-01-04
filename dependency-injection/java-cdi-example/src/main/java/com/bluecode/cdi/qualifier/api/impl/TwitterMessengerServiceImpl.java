package com.bluecode.cdi.qualifier.api.impl;

import com.bluecode.cdi.qualifier.annotations.TwitterBean;
import com.bluecode.cdi.qualifier.api.IMessengerService;
import com.bluecode.cdi.util.Logger;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
@TwitterBean
public class TwitterMessengerServiceImpl implements IMessengerService{
	private static final Logger log = Logger.getLogger(TwitterMessengerServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.qualifier.api.IMessengerService#sendMessage(java.lang.String, java.lang.String)
	 */
	public boolean sendMessage(String receiverId, String message) {
		log.print("Try send twitter message to: " + receiverId);
		log.print("Message: " + message);
		return true;
	}

}
