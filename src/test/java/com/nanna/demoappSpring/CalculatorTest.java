package com.nanna.demoappSpring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @copyright Reserved to Barclays Corporation
 * All rights reserved. Unauthorized copying of this file,
 * via any medium, is strictly prohibited.
 * <p>
 * This file is part of the Barclays software system and
 * is intended for internal use only.
 */
class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	void setUp ( ) {
		calculator = new Calculator ();
	}
	
	@Test
	void testAddition ( ) {
	
		assertEquals ( 5, calculator.add ( 2, 3 ) );
	}
	
	
	@Test
	void subtract ( ) {
		assertEquals ( 5, calculator.subtract ( 10, 5 ) );
	}
	
	@Test
	void multiply ( ) {
		assertEquals ( 6, calculator.multiply ( 2, 3 ) );
	}
	
	@Test
	void divide ( ) {
	assertEquals ( 5, calculator.divide ( 10, 2 ) );
	}
	
	@Test
	void testDivisionByZero() {
		ArithmeticException arithmeticException = assertThrows ( ArithmeticException.class , ( ) -> calculator.divide ( 10 , 0 ) );
		
	}
}