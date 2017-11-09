package com.doksusa.comment;

import java.sql.Date;

public class CommentDTO {
	
	
	
	int u_num;
	String u_nick;
	String u_comment;
	Date u_day;
	int num;
	String group;
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	public String getU_comment() {
		return u_comment;
	}
	public void setU_comment(String u_comment) {
		this.u_comment = u_comment;
	}
	public Date getU_day() {
		return u_day;
	}
	public void setU_day(Date u_day) {
		this.u_day = u_day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "CommentDTO [u_num=" + u_num + ", u_nick=" + u_nick + ", u_comment=" + u_comment + ", u_day=" + u_day
				+ ", num=" + num + ", group=" + group + "]";
	}
	public CommentDTO(int u_num, String u_nick, String u_comment, Date u_day, int num, String group) {
		super();
		this.u_num = u_num;
		this.u_nick = u_nick;
		this.u_comment = u_comment;
		this.u_day = u_day;
		this.num = num;
		this.group = group;
	}
	
	
	
	
}
