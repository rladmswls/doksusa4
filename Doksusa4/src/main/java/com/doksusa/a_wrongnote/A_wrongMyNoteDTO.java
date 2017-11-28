package com.doksusa.a_wrongnote;


public class A_wrongMyNoteDTO {
	int a_num;
	int a_subnum;
	int u_num;
	String a_link;
	public A_wrongMyNoteDTO(int a_num, int a_subnum, int u_num, String a_link) {
		super();
		this.a_num = a_num;
		this.a_subnum = a_subnum;
		this.u_num = u_num;
		this.a_link = a_link;
	}
	public A_wrongMyNoteDTO(){}
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
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getA_link() {
		return a_link;
	}
	public void setA_link(String a_link) {
		this.a_link = a_link;
	}
	@Override
	public String toString() {
		return "A_wrongMyNoteDTO [a_num=" + a_num + ", a_subnum=" + a_subnum + ", u_num=" + u_num + ", a_link=" + a_link
				+ "]";
	}
	
	

}
