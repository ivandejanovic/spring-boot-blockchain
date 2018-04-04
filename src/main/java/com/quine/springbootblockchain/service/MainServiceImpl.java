package com.quine.springbootblockchain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.http.ResponseEntity;

/**
 * @author Ivan Dejanovic
 */

@Service
public class MainServiceImpl implements MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Value("${name}")
    private String name;

    @Value("${nextPort}")
    private String nextPort;

    @Autowired
    private ApplicationContext context;

    @Override
    public String greetings() {
        String message = "Greetings from Spring Boot!";
        if (name != null) {
            message = "Greetings from Spring Boot app names: " + name;
        }
        return message;
    }

    @Override
    public String initiate() {
        if (nextPort == null)
            return "Next apps port not provided to app name: " + name;
        return callNext();
    }

    @Override
    public String block() {
        try {
            Runnable blockchain = (Runnable) context.getBean("blockchainServiceImpl");
            blockchain.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Block operation started in app name: " + name;
    }

    private String callNext() {
        String message = "Error happened on call next in app name: " + name;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:" + nextPort + "/block";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            message = response.toString();
        } catch (RestClientException e) {
            e.printStackTrace();
        }


        return message;
    }
}
