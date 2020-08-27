package com.javaspringdemo.SpringBootDemo.Controller;



	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.javaspringdemo.SpringBootDemo.repository.UserRepository;

	@RestController
	@RequestMapping(path="/user")
	public class UserController {

		@Autowired
		UserRepository userRepository;
		@GetMapping 
		public String check() {
			return "Welcome to spring boot demo";
		}
		
		@GetMapping(path="/getusers")
		public List<String> getAllUsers(){
			return userRepository.getAllUsers();
		}
	}

