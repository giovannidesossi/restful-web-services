package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	
	private Integer id;
	
	@Size(min=2, message = "Il nome deve avere almeno 2 lettere")
	private String name;
	
	@Past(message = "La data di nascita deve essere precedente alla data odierna")
	private LocalDate birthDate;
}
