package com.bluecode.cdi.qualifier.api.impl;

import javax.inject.Inject;

import com.bluecode.cdi.qualifier.annotations.FacebookBean;
import com.bluecode.cdi.qualifier.annotations.TwitterBean;
import com.bluecode.cdi.qualifier.api.IMessengerLocatorService;
import com.bluecode.cdi.qualifier.api.IMessengerService;
import com.bluecode.cdi.qualifier.enums.MessageType;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public class MessengerLocatorServiceImpl implements IMessengerLocatorService{
	
	@Inject
	@FacebookBean
	private IMessengerService facebookMessenger;
	
	@Inject
	@TwitterBean
	private IMessengerService twitterMessenger;

	
	/*
	 * (non-Javadoc)
	 * @see com.bluecode.cdi.qualifier.api.IMessengerLocatorService#sendMessageByType(com.bluecode.cdi.qualifier.enums.MessageType, java.lang.String, java.lang.String)
	 */
	public boolean sendMessageByType(MessageType type, String receiverId, String message) {
		boolean response = false;
		switch (type) {
		case FACEBOOK:
			response = facebookMessenger.sendMessage(receiverId, message);
			break;
		case TWITTER:
			response = twitterMessenger.sendMessage(receiverId, message);
		default:
			break;
		}
		return response;
	}

}
