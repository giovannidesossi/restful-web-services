package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Pippo", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Pluto", LocalDate.now().minusYears(5)));
		users.add(new User(++usersCount,"Paperino", LocalDate.now().minusYears(35)));
		users.add(new User(++usersCount,"Paperone", LocalDate.now().minusYears(70)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		User user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
}
