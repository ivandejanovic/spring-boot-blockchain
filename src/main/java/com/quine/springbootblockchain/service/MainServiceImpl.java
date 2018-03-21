/**
 * 
 */
package com.quine.springbootblockchain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Dejanovic
 *
 */

@Service
public class MainServiceImpl implements MainService {
	@Value("${name}")
	private String name;
	
	@Value("${port}")
	private String port;

	@Override
	public String greetings() {
		//String name = System.getProperty("name");
		String message = "Greetings from Spring Boot!";
		if (name != null) {
			message = "Greetings from Spring Boot app names: " + name;
		}
		return message;
	}

}
