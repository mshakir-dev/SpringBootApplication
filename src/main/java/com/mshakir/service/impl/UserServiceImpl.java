package com.mshakir.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshakir.Repository.UserRepository;
import com.mshakir.entity.UserEntity;
import com.mshakir.service.UserService;
import com.mshakir.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		if (userRepository.findUserByEmail(user.getEmail()) != null) throw new RuntimeException ("Record Already Exist");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setUserId("mcleod_software123");
		userEntity.setEncryptedPassword("mshakir12309865");
		
		UserEntity storedUserDetails =  userRepository.save(userEntity);
		UserDto returnValue = new UserDto();
		
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

}
