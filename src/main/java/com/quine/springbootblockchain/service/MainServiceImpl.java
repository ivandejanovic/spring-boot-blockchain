/**
 * 
 */
package com.quine.springbootblockchain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Dejanovic
 *
 */

@Service
public class MainServiceImpl implements MainService {
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
			String url = "http://localhost:" + nextPort + "/block";

			URL obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			message = response.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}
}
