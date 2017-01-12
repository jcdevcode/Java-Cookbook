package com.bluecode.cdi.scopes.api.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.bluecode.cdi.scopes.api.ICallerService;
import com.bluecode.cdi.scopes.api.ISimpleBeanService;


@Named("CallerServiceOne")
public class CallerServiceOne implements ICallerService {
	
	@Inject
	ISimpleBeanService beanService;

	public void callService() {
		beanService.doSomething();
	}

}
