package com.mshakir.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshakir.Repository.UserRepository;
import com.mshakir.entity.UserEntity;
import com.mshakir.service.UserService;
import com.mshakir.shared.Utils;
import com.mshakir.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto user) throws Exception {

		if (userRepository.findUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record Already Exist with Same Email");

		UserEntity userEntity = new UserEntity();
		UserEntity storedUserDetails = null;
		UserDto returnValue = null;

		BeanUtils.copyProperties(user, userEntity);

		String userIDRandom = utils.generateUserId(20);

		if (userEntity.getFirstName().equalsIgnoreCase("Scott")) {
			userEntity.setCoolStatus("Not Cool");
		} else {
			userEntity.setCoolStatus("Cool");
		}
		userEntity.setUserId(userIDRandom);

		if (isValidPassword(user.getPassword())) {
			userEntity.setEncryptedPassword(user.getPassword());
			storedUserDetails = userRepository.save(userEntity);
			returnValue = new UserDto();
			BeanUtils.copyProperties(storedUserDetails, returnValue);

		} else {
			throw new Exception("Invalid Password!");
		}
		return returnValue;
	}

	// Method to Check If the Password Contains (J), (k), and (minimum eight letters).
	// Used Regular Expression
	public static boolean isValidPassword(String password) {

		String regex = "^(?=.*[J])" + "(?=.*[k])" + ".{8,100}$";
		Pattern p = Pattern.compile(regex);
		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);
		return m.matches();
	}

	@Override
	public UserDto updateUser(String userId, UserDto userDto) throws Exception {

		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null) {
			throw new Exception("No User Found");
		}

		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setAge(userDto.getAge());

		if (userEntity.getFirstName().equalsIgnoreCase("Scott")) {
			userEntity.setCoolStatus("Not Cool");
		} else {
			userEntity.setCoolStatus("Cool");
		}

		if (isValidPassword(userDto.getPassword())) {
			userEntity.setEncryptedPassword(userDto.getPassword());

		} else {
			throw new Exception("Invalid Password!");
		}

		UserEntity updatedUserDetails = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetails, returnValue);
		return returnValue;
	}

}