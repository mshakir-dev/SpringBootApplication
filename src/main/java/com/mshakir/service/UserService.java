package com.mshakir.service;

import com.mshakir.shared.dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto user) throws Exception;
	public UserDto updateUser(String userId, UserDto userDto) throws Exception;
}
