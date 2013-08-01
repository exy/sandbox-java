package org.alexis.mon1erMvc.dao;

import org.springframework.stereotype.Component;

@Component(value="userDto")
public class UserDto {

	private String name;
	private String password;
	private String login;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
