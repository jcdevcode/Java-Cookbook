package com.bluecode.cdi;

import javax.inject.Inject;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bluecode.cdi.simple.CalculatorService;
import com.bluecode.cdi.util.Logger;



@RunWith(CdiRunner.class)
public class SimpleInjectTest {
	private static final Logger log = Logger.getLogger(SimpleInjectTest.class);
	
	@Inject
	CalculatorService calculator;

	@Test
	public void testAdd(){
	
		int opOne = 10;
		int opTwo = 20;		
		int expectedResult = 30;
		
		int result = calculator.add(opOne, opTwo);
		log.print("Result from injected class: " + result);
		Assert.assertEquals(result, expectedResult);
	}
	
	

	@Test
	public void testPow(){
		double base = 2;
		double exp = 8;
		double expectedResult = 256.0;
		
		double result = calculator.pow(base, exp);
		
		log.print("Result from injected class: " + result);
		Assert.assertEquals(expectedResult, result, 0.0);
	}

}
