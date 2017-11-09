package com.doksusa.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO user;
	
	public void setUser(UserDAO user) {
		this.user = user;
	}

	@Override
	public List<UserDTO> user_selectAll() {
		return user.user_selectAll();
	}

	@Override
	public UserDTO user_select(String u_id) {
		return user.user_select(u_id);
	}

	@Override
	public int user_insert(UserDTO userdto) {
		return user.user_insert(userdto);
	}

	@Override
	public int user_update(String u_pw) {
		return user.user_update(u_pw);
	}

	@Override
	public int user_delete(String u_id) {
		return user.user_delete(u_id);
	}

	@Override
	public UserDTO login(String u_id, String u_pw) {
		return user.login(u_id, u_pw);
	}

}
