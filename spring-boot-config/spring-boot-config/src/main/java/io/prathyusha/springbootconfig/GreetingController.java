package io.prathyusha.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${app.desription: default value}")
	private String greetingMessage;
	
	@Value("some static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@Autowired
	private Environment env;
	
	public GreetingController() {
		
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		//return greetingMessage + staticMessage + listValues + dbValues;
		return dbSettings.getConnection() + dbSettings.getHost();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		
		return env.toString();
	}
	
	

}


/*
 * @Value("#{${dbValues}}") private Map<String,String> dbValues;
 */