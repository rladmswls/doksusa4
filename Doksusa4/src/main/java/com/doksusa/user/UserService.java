package com.doksusa.user;

import java.util.List;

public interface UserService {

	public List<UserDTO> user_selectAll();

	public UserDTO user_select(String u_id);

	public int user_insert(UserDTO userdto);

	public int user_update(String u_pw);

	public int user_delete(String u_id);

	public UserDTO login(String u_id, String u_pw);

}
