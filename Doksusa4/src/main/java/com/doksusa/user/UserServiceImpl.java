package com.doksusa.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

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
	public int user_delete(int u_num) {
		return user.user_delete(u_num);
	}

	@Override
	public UserDTO login(String u_id, String u_pw) {
		return user.login(u_id, u_pw);
	}

	@Override
	public UserDTO user_select2(String u_id, String u_pw) {
		return user.user_select2(u_id, u_pw);
	}

	@Override
	public UserDTO user_update(UserDTO userdto) {
		return user.user_update(userdto);
	}

	@Override
	public UserDTO user_selectByNick(String u_nick) {
		return user.user_selectByNick(u_nick);
	}

	@Override
	public UserDTO user_selectByPhone(String u_phone) {
		return user.user_selectByPhone(u_phone);
	}

	@Override
	public UserDTO user_select3(String u_id, String u_nick, String u_phone) {
		return user.user_select3(u_id, u_nick, u_phone);
	}

}