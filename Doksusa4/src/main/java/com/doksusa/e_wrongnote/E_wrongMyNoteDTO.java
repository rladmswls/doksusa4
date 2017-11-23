package com.doksusa.e_wrongnote;

import java.util.List;

public class E_wrongMyNoteDTO {
	int u_num;
	List<Integer> subnum;
	String e_link;
	public E_wrongMyNoteDTO(int u_num, List<Integer> subnum, String e_link) {
		super();
		this.u_num = u_num;
		this.subnum = subnum;
		this.e_link = e_link;
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


	public String getE_link() {
		return e_link;
	}


	public void setE_link(String e_link) {
		this.e_link = e_link;
	}


	public E_wrongMyNoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "E_wrongMyNoteDTO [u_num=" + u_num + ", subnum=" + subnum + ", e_link=" + e_link + "]";
	}
	
	
}
