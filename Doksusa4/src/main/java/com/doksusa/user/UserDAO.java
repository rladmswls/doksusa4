package com.doksusa.user;

import java.util.List;

public interface UserDAO {

   public List<UserDTO> user_selectAll();

   public UserDTO user_select(String u_id);
   
   public UserDTO user_selectByNick(String u_nick);

   public int user_insert(UserDTO userdto);

   public UserDTO user_update(String u_id,String u_pw);

   public int user_delete(String u_id);

   public UserDTO login(String u_id, String u_pw);
   
   public UserDTO user_select2(String u_id, String u_pw);


}