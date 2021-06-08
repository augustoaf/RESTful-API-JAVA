package com.myapp.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.restservice.model.Greeting;

//@RestController annotation marks the class as a controller where every method returns a domain object (REST purpose) instead of a view (view would be used in a ordinary MVC project to render a HTML page)
@RestController
public class GreetingController {

	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//@GetMapping annotation is a HTTP GET request mapping from "/greeting" url to greeting() method
	//there are other annotations like @PostMapping for POST requests and also this another way @RequestMapping(method=GET)
	
	//return the greeting with the name provided
	@GetMapping("/greeting") 
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		
		return greeting;
	}
	
	//update the greeting template
	@PostMapping("/greeting") 
	public Greeting greetingPost(@RequestParam(value = "greeting-message", defaultValue = "Hi") String greeting) {
			
		this.updateTemplate(greeting);
		
		return null;
	}
	
	private void updateTemplate(String greeting) {
		
		template = greeting + ", %s!";
	}
}