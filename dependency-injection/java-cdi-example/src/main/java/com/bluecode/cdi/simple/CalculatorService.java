package com.bluecode.cdi.simple;

import javax.inject.Inject;

/**
 * Calculator.
 * @author Julio Cesar Bolaños Palacios
 * @since 03/01/2017
 * @version 1.0
 */
public class CalculatorService {
	
	@Inject
	SimpleCalculator simpleCalculator;
	
	@Inject
	AdvancedCalculator advancedCalculator;

	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b){
		return simpleCalculator.add(a, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double pow(double a, double b){
		return advancedCalculator.pow(a, b);
	}
}
