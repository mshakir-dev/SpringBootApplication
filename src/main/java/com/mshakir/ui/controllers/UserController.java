package com.mshakir.ui.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping(path="/{userId}")
	public UserRest getUsers(@PathVariable String userId) throws Exception{
		UserRest returnValue = new UserRest();
		
		UserDto userDto = userService.getUserByUserId(userId);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
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
	
	@PutMapping(path="/{userId}")
	public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) throws Exception{
		
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto updateUser = userService.updateUser(userId, userDto);
		BeanUtils.copyProperties(updateUser, returnValue);
		return returnValue;
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete Item";
	}
}
