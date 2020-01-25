package com.appsdeveloperblog.app.ws.mobileappws.service;

import java.util.List;

import com.appsdeveloperblog.app.ws.mobileappws.shared.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);
	public UserDto getUser(String userId);
}
