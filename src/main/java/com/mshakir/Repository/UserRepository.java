package com.mshakir.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mshakir.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	// Custom that We need to add it in our Application to perform extra Crud Functionality
	UserEntity findUserByEmail(String email);
}
