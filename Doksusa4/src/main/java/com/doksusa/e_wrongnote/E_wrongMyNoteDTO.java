package com.doksusa.e_wrongnote;


public class E_wrongMyNoteDTO {
	int e_num;
	int e_subnum;
	int u_num;
	String e_link;
	
	public E_wrongMyNoteDTO(int e_num, int e_subnum, int u_num, String e_link) {
		super();
		this.e_num = e_num;
		this.e_subnum = e_subnum;
		this.u_num = u_num;
		this.e_link = e_link;
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
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getE_link() {
		return e_link;
	}
	public void setE_link(String e_link) {
		this.e_link = e_link;
	}
	@Override
	public String toString() {
		return "E_wrongMyNoteDTO [e_num=" + e_num + ", e_subnum=" + e_subnum + ", u_num=" + u_num + ", e_link=" + e_link
				+ "]";
	}

	

	
}
