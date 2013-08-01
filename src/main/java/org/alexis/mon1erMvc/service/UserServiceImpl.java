package org.alexis.mon1erMvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.alexis.mon1erMvc.dao.UserDao;
import org.alexis.mon1erMvc.dao.UserDto;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public List<UserDto> getUsers() {
		
		return userDao.getUsers();
		
	}
}
