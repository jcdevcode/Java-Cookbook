package com.bluecode.cdi;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.qualifier.api.IMessengerLocatorService;
import com.bluecode.cdi.qualifier.api.impl.FacebookMessengerServiceImpl;
import com.bluecode.cdi.qualifier.api.impl.MessengerLocatorServiceImpl;
import com.bluecode.cdi.qualifier.api.impl.TwitterMessengerServiceImpl;
import com.bluecode.cdi.qualifier.enums.MessageType;

@RunWith(CdiRunner.class)
@AdditionalClasses({MessengerLocatorServiceImpl.class, 
	FacebookMessengerServiceImpl.class, 
	TwitterMessengerServiceImpl.class})
public class QualifierInjectTest {
	
	@Inject
	IMessengerLocatorService messenger;
	


	
	@Test
	public void sendFacebookMessageTest(){
		messenger.sendMessageByType(MessageType.FACEBOOK, "jcesar1234", "Hello from facebook.");
	}

	@Test
	public void sendTwitterMessageTest(){
		messenger.sendMessageByType(MessageType.TWITTER, "neto666", "Hello from twitter.");
	}

}
