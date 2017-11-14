package com.doksusa.community;

import java.sql.Date;

public class CommunityDTO {
	int c_num;
	String c_group;
	Date day;
	String title;
	String f_foreword;
	int u_num;

	public CommunityDTO() {
		super();
	}

	public CommunityDTO(int c_num, String c_group, Date day, String title, String f_foreword, int u_num) {
		super();
		this.c_num = c_num;
		this.c_group = c_group;
		this.day = day;
		this.title = title;
		this.f_foreword = f_foreword;
		this.u_num = u_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_group() {
		return c_group;
	}

	public void setC_group(String c_group) {
		this.c_group = c_group;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getF_foreword() {
		return f_foreword;
	}

	public void setF_foreword(String f_foreword) {
		this.f_foreword = f_foreword;
	}

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	@Override
	public String toString() {
		return "CommunityDTO [c_num=" + c_num + ", c_group=" + c_group + ", day=" + day + ", title=" + title
				+ ", f_foreword=" + f_foreword + ", u_num=" + u_num + "]";
	}

}
