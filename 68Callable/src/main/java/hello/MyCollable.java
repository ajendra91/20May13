package hello;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyCollable implements Callable<String>{

	@Autowired
	public RestTemplate rt;
	
	@Override
	public String call() throws Exception {
		return rt.getForObject("https://gturnquist-quoters.cfapps.io/api", String.class);
	}

	
	
}
