package com.doksusa.user;

import java.util.List;

public interface UserService {

   public List<UserDTO> user_selectAll();

   public UserDTO user_select(String u_id);
   
   public UserDTO user_selectByNick(String u_nick);
   
   public UserDTO user_selectByPhone(String u_phone);
   
   public UserDTO user_select2(String u_id, String u_pw);

   public int user_insert(UserDTO userdto);

   public UserDTO user_update(UserDTO userdto);

   public int user_delete(int u_num);

   public UserDTO login(String u_id, String u_pw);
   
   public UserDTO user_select3(String u_id,String u_nick,String u_phone);

}