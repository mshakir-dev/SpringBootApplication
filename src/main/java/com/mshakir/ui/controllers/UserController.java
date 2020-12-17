package com.mshakir.ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers() {
		return "Get List";
	}
	
	
	@PostMapping
	public String createUser() {
		return "Add New Item";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update Item";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete Item";
	}
}
