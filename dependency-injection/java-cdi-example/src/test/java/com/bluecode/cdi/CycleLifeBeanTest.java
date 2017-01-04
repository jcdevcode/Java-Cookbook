package com.bluecode.cdi;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.lifebean.api.ISimpleBean;
import com.bluecode.cdi.lifebean.api.impl.SimpleBeanImpl;

@RunWith(CdiRunner.class)
@AdditionalClasses({SimpleBeanImpl.class})
public class CycleLifeBeanTest {
	
	@Inject
	ISimpleBean simpleBean;
	
	@Test
	public void testBeanInjection(){
		simpleBean.doSomething();
	}
}
