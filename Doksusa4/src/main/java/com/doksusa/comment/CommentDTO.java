package com.doksusa.comment;

import java.sql.Date;

public class CommentDTO {

	int ct_num;
	int c_num;
	int ctu_num;
	String ct_comment;
	Date ct_date;

	public CommentDTO() {
		super();
	}

	public CommentDTO(int ct_num, int c_num, int ctu_num, String ct_comment, Date ct_date) {
		super();
		this.ct_num = ct_num;
		this.c_num = c_num;
		this.ctu_num = ctu_num;
		this.ct_comment = ct_comment;
		this.ct_date = ct_date;
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

	public int getCtu_num() {
		return ctu_num;
	}

	public void setCtu_num(int ctu_num) {
		this.ctu_num = ctu_num;
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

	@Override
	public String toString() {
		return "CommentDTO [ct_num=" + ct_num + ", c_num=" + c_num + ", ctu_num=" + ctu_num + ", ct_comment=" + ct_comment
				+ ", ct_date=" + ct_date + "]";
	}

}
