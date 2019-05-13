package com.example.RetryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableRetry
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@RequestMapping("/")
	@Retryable(value= {NumberFormatException.class,NullPointerException.class})
	public String myApp() {
		System.out.println("myapp is calling");
		Integer.parseInt("");
		String str=null;
		str.length();
		return "success";
	}

	@Recover
	public String recover(NumberFormatException ex) {
		System.out.println("NumberFormatException");
		return "recover=>NumberFormatException";
	}

	@Recover
	public String recover(NullPointerException ex) {
		System.out.println("NullPointerException");
		return "recover=>NullPointerException";
	}



}


