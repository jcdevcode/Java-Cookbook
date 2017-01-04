package com.bluecode.cdi;

import javax.inject.Inject;

import org.jboss.weld.exceptions.DeploymentException;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.named.api.IPrinterHello;
import com.bluecode.cdi.named.api.impl.MexicanPrinterHelloImpl;
import com.bluecode.cdi.named.api.impl.PrinterHelloImpl;

@RunWith(CdiRunner.class)
@AdditionalClasses({PrinterHelloImpl.class, MexicanPrinterHelloImpl.class})
public class MultipleNamedInjectTest {
	
	@Inject
	//@Named("PrinterHelloImpl")
	IPrinterHello printerHello;
	
	@Inject
	//@Named("MexicanPrinterHelloImpl")
	IPrinterHello otherPrinterHello;
	
	@Test(expected=DeploymentException.class)
	public void testPrintHello(){
		printerHello.printHello();
		otherPrinterHello.printHello();
	}
	
	@Test(expected=DeploymentException.class)
	public void testSayHello(){
		printerHello.sayHello("Julio Cesar");
		otherPrinterHello.sayHello("Iván");
	}

}
