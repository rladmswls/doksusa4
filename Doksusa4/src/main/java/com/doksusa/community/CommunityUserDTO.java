package com.doksusa.community;

import java.sql.Date;

public class CommunityUserDTO {
	int c_num;
	int u_num;
	String f_foreword;
	int c_group;
	String c_title;
	String c_content;
	Date c_date;
	String u_nick;
	int comment_num;
	
	public CommunityUserDTO() {
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public CommunityUserDTO(int c_num, int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Date c_date, String u_nick, int comment_num) {
		super();
		this.c_num = c_num;
		this.u_num = u_num;
		this.f_foreword = f_foreword;
		this.c_group = c_group;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_date = c_date;
		this.u_nick = u_nick;
		this.comment_num = comment_num;
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
	public String getF_foreword() {
		return f_foreword;
	}
	public void setF_foreword(String f_foreword) {
		this.f_foreword = f_foreword;
	}
	public int getC_group() {
		return c_group;
	}
	public void setC_group(int c_group) {
		this.c_group = c_group;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	
	
	
	

	
	
}
