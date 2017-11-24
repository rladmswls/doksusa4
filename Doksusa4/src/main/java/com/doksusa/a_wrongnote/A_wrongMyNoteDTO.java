package com.doksusa.a_wrongnote;

import java.util.List;

public class A_wrongMyNoteDTO {
	int u_num;
	List<Integer> subnum;
	String a_link;
	public A_wrongMyNoteDTO(int u_num, List<Integer> subnum, String a_link){
		super();
		this.u_num = u_num;
		this.subnum = subnum;
		this.a_link = a_link;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public List<Integer> getSubnum() {
		return subnum;
	}
	public void setSubnum(List<Integer> subnum) {
		this.subnum = subnum;
	}
	public String getA_link() {
		return a_link;
	}
	public void setA_link(String a_link) {
		this.a_link = a_link;
	}
	public A_wrongMyNoteDTO() {
		super();
	}
	@Override
	public String toString() {
		return "A_wrongMyNoteDTO [u_num=" + u_num + ", subnum=" + subnum + ", a_link=" + a_link + "]";
	}

}
