package com.bluecode.cdi.qualifier.api;

/**
 * Interface for send messages
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public interface IMessengerService {
	/**
	 * Send message to user identified by receiverId;
	 * @param receiverId
	 * @param message
	 * @return
	 */
	public boolean sendMessage(String receiverId, String message);
}
