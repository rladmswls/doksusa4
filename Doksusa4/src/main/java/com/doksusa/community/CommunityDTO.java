package com.doksusa.community;

import java.sql.Date;

public class CommunityDTO {
	String group;
	int num;
	Date day;
	String title;
	String foreword;
	int u_num;

	public CommunityDTO() {
		super();
	}

	public CommunityDTO(String group, int num, Date day, String title, String foreword, int u_num) {
		super();
		this.group = group;
		this.num = num;
		this.day = day;
		this.title = title;
		this.foreword = foreword;
		this.u_num = u_num;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getForeword() {
		return foreword;
	}

	public void setForeword(String foreword) {
		this.foreword = foreword;
	}

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	@Override
	public String toString() {
		return "CommunityDTO [group=" + group + ", num=" + num + ", day=" + day + ", title=" + title + ", foreword="
				+ foreword + ", u_num=" + u_num + "]";
	}
}
