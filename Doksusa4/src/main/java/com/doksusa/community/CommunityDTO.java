package com.doksusa.community;

import java.sql.Date;

public class CommunityDTO {
	int c_num;
	int u_num;
	String f_foreword;
	int c_group;
	String c_title;
	String c_content;
	Date c_date;

	public CommunityDTO() {
		super();
	}

	public CommunityDTO(int c_num, int u_num, String f_foreword, int c_group, String c_title, String c_content,
			Date c_date) {
		super();
		this.c_num = c_num;
		this.u_num = u_num;
		this.f_foreword = f_foreword;
		this.c_group = c_group;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_date = c_date;
	}

	@Override
	public String toString() {
		return "CommunityDTO [c_num=" + c_num + ", u_num=" + u_num + ", f_foreword=" + f_foreword + ", c_group="
				+ c_group + ", c_title=" + c_title + ", c_content=" + c_content + ", c_date=" + c_date + "]";
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
	
	

}