package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TalkCollableApplication {
	
	@Bean
	public RestTemplate fun() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(TalkCollableApplication.class, args);
	}

}
