package com.doksusa.e_sub;

public class E_subDTO {

	int e_num;
	int e_subnum;
	String e_sublink;
	String e_subanswer;
	String e_subsol;

	public E_subDTO() {
		super();
	}

	public E_subDTO(int e_num, int e_subnum, String e_sublink, String e_subanswer, String e_subsol) {
		super();
		this.e_num = e_num;
		this.e_subnum = e_subnum;
		this.e_sublink = e_sublink;
		this.e_subanswer = e_subanswer;
		this.e_subsol = e_subsol;
	}

	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	public int getE_subnum() {
		return e_subnum;
	}

	public void setE_subnum(int e_subnum) {
		this.e_subnum = e_subnum;
	}

	public String getE_sublink() {
		return e_sublink;
	}

	public void setE_sublink(String e_sublink) {
		this.e_sublink = e_sublink;
	}

	public String getE_subanswer() {
		return e_subanswer;
	}

	public void setE_subanswer(String e_subanswer) {
		this.e_subanswer = e_subanswer;
	}

	public String getE_subsol() {
		return e_subsol;
	}

	public void setE_subsol(String e_subsol) {
		this.e_subsol = e_subsol;
	}

	@Override
	public String toString() {
		return "E_subDTO [e_num=" + e_num + ", e_subnum=" + e_subnum + ", e_sublink=" + e_sublink + ", e_subanswer="
				+ e_subanswer + ", e_subsol=" + e_subsol + "]";
	}

}
