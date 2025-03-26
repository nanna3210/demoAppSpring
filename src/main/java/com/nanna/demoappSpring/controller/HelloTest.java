package com.nanna.demoappSpring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @copyright Reserved to Barclays Corporation
 * All rights reserved. Unauthorized copying of this file,
 * via any medium, is strictly prohibited.
 * <p>
 * This file is part of the Barclays software system and
 * is intended for internal use only.
 */
@RestController
public class HelloTest {
	
@GetMapping( "/hello" )
	public String hello ( ) {
		return "Hello World";
	}
	
}
