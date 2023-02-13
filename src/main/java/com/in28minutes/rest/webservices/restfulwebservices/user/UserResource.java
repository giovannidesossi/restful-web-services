package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User retrieveUser(@PathVariable Integer userId){
		return userDaoService.findOne(userId);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable Integer userId){
		userDaoService.deleteById(userId);
	}

	@PostMapping("/users")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{userId}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();//HATEOAS...?
		
	}
}
