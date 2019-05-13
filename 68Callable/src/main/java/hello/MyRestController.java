package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {

	@Autowired
	public RestTemplate rt;
	
	@Autowired
	public MyCollable myCollable;
	
	@RequestMapping("/myapp")
	public String myapp() {
		System.out.println(System.currentTimeMillis()/1000);
		for(int i=0;i<100;i++) {
			rt.getForObject("https://gturnquist-quoters.cfapps.io/api", String.class);
		}
		System.out.println(System.currentTimeMillis()/1000);
		return "success";
	}

	@RequestMapping("/newApp")
	public String newApp() throws InterruptedException, ExecutionException {
		ExecutorService excutor =Executors.newFixedThreadPool(10);
		List<Future<String>> list =new ArrayList<Future<String>>();
		System.out.println(System.currentTimeMillis()/1000);
		for(int i=0;i<100;i++) {
			
			Future<String> future =excutor.submit(myCollable);
			list.add(future);
		}
		for(Future<String> fut:list) {
			fut.get();
		}
		excutor.shutdown();
		System.out.println(System.currentTimeMillis()/1000);
		
		return "success";
	}
	
}
