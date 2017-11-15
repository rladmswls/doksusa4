package com.doksusa.a_sub;

public class A_subDTO {

	int a_num;
	int a_subnum;
	String a_sublink;
	String a_subanswer;

	public A_subDTO() {
		super();
	}

	public A_subDTO(int a_num, int a_subnum, String a_sublink, String a_subanswer) {
		super();
		this.a_num = a_num;
		this.a_subnum = a_subnum;
		this.a_sublink = a_sublink;
		this.a_subanswer = a_subanswer;
	}

	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}

	public int getA_subnum() {
		return a_subnum;
	}

	public void setA_subnum(int a_subnum) {
		this.a_subnum = a_subnum;
	}

	public String getA_sublink() {
		return a_sublink;
	}

	public void setA_sublink(String a_sublink) {
		this.a_sublink = a_sublink;
	}

	public String getA_subanswer() {
		return a_subanswer;
	}

	public void setA_subanswer(String a_subanswer) {
		this.a_subanswer = a_subanswer;
	}

	@Override
	public String toString() {
		return "A_subDTO [a_num=" + a_num + ", a_subnum=" + a_subnum + ", a_sublink=" + a_sublink + ", a_subanswer="
				+ a_subanswer + "]";
	}

}
