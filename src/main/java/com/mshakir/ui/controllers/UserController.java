package com.mshakir.ui.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mshakir.service.UserService;
import com.mshakir.shared.dto.UserDto;
import com.mshakir.ui.models.request.UserDetailsRequestModel;
import com.mshakir.ui.models.response.UserRest;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping
	public String getUsers() {
		return "Get List";
	}
	
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createuser = userService.createUser(userDto);
		BeanUtils.copyProperties(createuser, returnValue);
		return returnValue;
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
