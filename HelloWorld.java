package com.riyaz.helloworld.test;

public class HelloWorld {

	private String name;
	
	private String greet;

	public HelloWorld() {}
	public HelloWorld(String name, String greet) {
		super();
		this.name = name;
		this.greet = greet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + name + ", greet=" + greet + "]";
	}
	
	
	
}
