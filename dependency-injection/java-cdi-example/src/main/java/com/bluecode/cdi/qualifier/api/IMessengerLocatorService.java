package com.bluecode.cdi.qualifier.api;

import com.bluecode.cdi.qualifier.enums.MessageType;

/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public interface IMessengerLocatorService {
	/**
	 * Send message by type.
	 * @param type
	 * @param reveiverId
	 * @param message
	 * @return
	 */
	public boolean sendMessageByType(MessageType type, String receiverId, String message);
}
