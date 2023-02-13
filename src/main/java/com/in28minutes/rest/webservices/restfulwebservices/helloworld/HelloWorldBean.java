package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HelloWorldBean {

	private String message;

	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
