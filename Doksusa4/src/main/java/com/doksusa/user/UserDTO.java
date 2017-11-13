package com.doksusa.user;

public class UserDTO {

	int u_num;
	String u_id;
	String u_pw;
	String u_nick;
	String u_phone;

	
	public UserDTO() {
		super();
	}


	public int getU_num() {
		return u_num;
	}


	public void setU_num(int u_num) {
		this.u_num = u_num;
	}


	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}


	public String getU_pw() {
		return u_pw;
	}


	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}


	public String getU_nick() {
		return u_nick;
	}


	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}


	public String getU_phone() {
		return u_phone;
	}


	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}


	public UserDTO(int u_num, String u_id, String u_pw, String u_nick, String u_phone) {
		super();
		this.u_num = u_num;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_nick = u_nick;
		this.u_phone = u_phone;
	}


	@Override
	public String toString() {
		return "UserDTO [u_num=" + u_num + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_nick=" + u_nick + ", u_phone="
				+ u_phone + "]";
	}


	
	
}
