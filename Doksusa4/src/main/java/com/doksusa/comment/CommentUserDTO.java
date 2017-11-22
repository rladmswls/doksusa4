package com.doksusa.comment;

import java.sql.Date;

public class CommentUserDTO {

	int ct_num;
	int c_num;
	int u_num;
	String ct_comment;
	Date ct_date;
	String u_nick;
	
	public CommentUserDTO() {
		super();
	}
	
	public CommentUserDTO(int ct_num, int c_num, int u_num, String ct_comment, Date ct_date, String u_nick) {
		super();
		this.ct_num = ct_num;
		this.c_num = c_num;
		this.u_num = u_num;
		this.ct_comment = ct_comment;
		this.ct_date = ct_date;
		this.u_nick = u_nick;
	}
	
	@Override
	public String toString() {
		return "CommentUserDTO [ct_num=" + ct_num + ", c_num=" + c_num + ", u_num=" + u_num + ", ct_comment="
				+ ct_comment + ", ct_date=" + ct_date + ", u_nick=" + u_nick + "]";
	}
	public int getCt_num() {
		return ct_num;
	}
	public void setCt_num(int ct_num) {
		this.ct_num = ct_num;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getCt_comment() {
		return ct_comment;
	}
	public void setCt_comment(String ct_comment) {
		this.ct_comment = ct_comment;
	}
	public Date getCt_date() {
		return ct_date;
	}
	public void setCt_date(Date ct_date) {
		this.ct_date = ct_date;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	
	
}
