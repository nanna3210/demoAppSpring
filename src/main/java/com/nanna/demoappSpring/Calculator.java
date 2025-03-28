package com.nanna.demoappSpring;

import org.springframework.stereotype.Service;

/**
 * @copyright Reserved to Barclays Corporation
 * All rights reserved. Unauthorized copying of this file,
 * via any medium, is strictly prohibited.
 * <p>
 * This file is part of the Barclays software system and
 * is intended for internal use only.
 */
@Service
public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return a / b;
	}
}
