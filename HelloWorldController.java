package com.riyaz.helloworld.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	
	@GetMapping(value = "/")
	public String testHelloworld()
	{
		return "Hello World";
	}
	@GetMapping(value = "/hello-world/test")
	public String test()
	{
		return "Hello World";
	}
	
	@GetMapping(value = "/hello-world/test-bean")
	public HelloWorld testBean()
	{
		//throw new RuntimeException("Some error found , please contact to support team !!");
		return new HelloWorld("Riyaz","Good Morning");
	}
	
	@GetMapping(value = "/hello-world/test-bean/name/{name}/greet/{greet}")
	public HelloWorld dynamicBean(@PathVariable String name,@PathVariable String greet)
	{
		//throw new RuntimeException("Some error found , please contact to support team !!");
		return new HelloWorld(name,greet);
	}
}
