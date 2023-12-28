package com.ahmed.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.users.entities.User;
import com.ahmed.users.service.UserService;
import com.ahmed.users.service.register.RegistrationRequest;

@RestController
@CrossOrigin(origins ="*")
public class UserRESTController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
	return userservice.findAllUsers();
	}
	
	@RequestMapping(path="signup", method = RequestMethod.POST)
	public User createUser (@RequestBody User user) {
	return userservice.saveUser(user);
	}
	
	@PostMapping("/register")
	public User register (@RequestBody RegistrationRequest request) {
		return userservice.registerUser(request);	
	}
	
	@GetMapping("/verifyEmail/{token}")
	public User verifyEmail(@PathVariable("token") String token){
		return userservice.validateToken(token);
	}

}
