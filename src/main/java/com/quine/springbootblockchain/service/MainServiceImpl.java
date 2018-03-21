/**
 * 
 */
package com.quine.springbootblockchain.service;

import org.springframework.stereotype.Service;

/**
 * @author Ivan Dejanovic
 *
 */

@Service
public class MainServiceImpl implements MainService {

	@Override
	public String greetings() {
		return "Greetings from Spring Boot!";
	}

}
