package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.mobileappws.service.UserService;
import com.appsdeveloperblog.app.ws.mobileappws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		
		return "get user was called";
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping()
	//@RequestMapping()
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
		System.err.println("InsidePost");
		//return "create user was called";
		UserRest returnValue = new UserRest();
		try {
			
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userDetails, userDto);
			
			UserDto createdUser = userService.createUser(userDto);
			BeanUtils.copyProperties(createdUser, returnValue);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		
		return "delete user was called";
	}
}
