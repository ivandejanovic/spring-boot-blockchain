package com.quine.springbootblockchain.controller;

import org.springframework.web.bind.annotation.RestController;

import com.quine.springbootblockchain.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {
	
	@Autowired
	private MainService service;

	@RequestMapping("/")
	public String index() {
		return service.greetings();
	}
	
	@RequestMapping("/initiate")
	public String initiate() {
		return service.initiate();
	}
	
	@RequestMapping("/block")
	public String block() {
		return service.block();
	}
}
