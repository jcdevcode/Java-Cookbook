package com.bluecode.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.named.api.IPrinterHello;
import com.bluecode.cdi.named.api.impl.MexicanPrinterHelloImpl;
import com.bluecode.cdi.named.api.impl.PrinterHelloImpl;

@RunWith(CdiRunner.class)
@AdditionalClasses({PrinterHelloImpl.class, MexicanPrinterHelloImpl.class})
public class NamedInjectTest {
	
	@Inject
	@Named("PrinterHelloImpl")
	IPrinterHello printerHello;
	
	@Test
	public void testPrintHello(){
		printerHello.printHello();
	}
	
	@Test
	public void testSayHello(){
		printerHello.sayHello("Julio Cesar");
	}

}
