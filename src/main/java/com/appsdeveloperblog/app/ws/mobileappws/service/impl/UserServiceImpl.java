package com.appsdeveloperblog.app.ws.mobileappws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.mobileappws.UserRepository;
import com.appsdeveloperblog.app.ws.mobileappws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.mobileappws.service.UserService;
import com.appsdeveloperblog.app.ws.mobileappws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		 UserEntity userEntity = new UserEntity();
		 BeanUtils.copyProperties(user, userEntity);
		 
		 userEntity.setEncryptedPassword("test");
		 userEntity.setUserId("testUserId");
		 
		 UserEntity storedUserDetails = userRepository.save(userEntity);
		 
		 UserDto returnValue = new UserDto();
		 BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto getUser(String userId) {
		
		List<UserEntity> storedUserDetails = userRepository.findByUserId(userId);
		
		List<UserDto> returnValue = new ArrayList<UserDto>();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue.get(0);
	}
	
	

}
