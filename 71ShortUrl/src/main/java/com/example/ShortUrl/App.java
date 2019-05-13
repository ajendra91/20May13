package com.example.ShortUrl;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

	private Map<String, String> shortenUrlList2 = new HashMap<>();
	

	@RequestMapping(value="/demo", method=RequestMethod.GET)
	public String full(@RequestParam String full) throws MalformedURLException {
		String randomChar = getRandomChars();
		String s="http://localhost:9090/s/"+randomChar;
		 shortenUrlList2.put(randomChar, full);
		return s;
	}
	
	@RequestMapping(value="/s/{rs}", method=RequestMethod.GET)
	public void getFullUrl(HttpServletResponse response, @PathVariable String rs) throws IOException {
		System.out.println(shortenUrlList2.get(rs));
		response.sendRedirect(shortenUrlList2.get(rs));
	}



	private String getRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;
	}
		
}