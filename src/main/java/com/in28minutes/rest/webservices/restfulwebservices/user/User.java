package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private Integer id;
	private String name;
	private LocalDate birthDate;

}
