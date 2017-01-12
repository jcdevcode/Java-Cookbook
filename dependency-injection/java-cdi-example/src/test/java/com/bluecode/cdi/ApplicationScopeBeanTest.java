package com.bluecode.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.scopes.api.ICallerService;
import com.bluecode.cdi.scopes.api.impl.ApplicationBeanService;
import com.bluecode.cdi.scopes.api.impl.CallerServiceOne;
import com.bluecode.cdi.scopes.api.impl.CallerServiceTwo;

@RunWith(CdiRunner.class)
@AdditionalClasses({CallerServiceOne.class, CallerServiceTwo.class, ApplicationBeanService.class})
public class ApplicationScopeBeanTest {
	
	@Inject
	@Named("CallerServiceOne")
	ICallerService callerServiceOne;
	
	@Inject
	@Named("CallerServiceTwo")
	ICallerService callerServiceTwo;
	
	
	 @Test
	 public void applicationTestBean(){
		 callerServiceOne.callService();
		 callerServiceOne.callService();
		 callerServiceOne.callService();
		 
		 callerServiceTwo.callService();
		 callerServiceTwo.callService();
		 callerServiceTwo.callService();
	 }

}
