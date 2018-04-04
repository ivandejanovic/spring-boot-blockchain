package com.quine.springbootblockchain.controller;

import org.springframework.web.bind.annotation.RestController;

import com.quine.springbootblockchain.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

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

    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    String sync(@RequestBody String data) {
        return service.sync(data);
    }
}
