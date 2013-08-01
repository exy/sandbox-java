package org.alexis.mon1erMvc.service;

import java.util.List;

import org.alexis.mon1erMvc.dao.UserDto;

public interface UserService {

	public List<UserDto> getUsers();

}