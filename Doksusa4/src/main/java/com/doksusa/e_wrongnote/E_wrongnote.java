package com.doksusa.e_wrongnote;

public class E_wrongnote {
	int e_num;
	int u_num;
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	@Override
	public String toString() {
		return "E_wrongnote [e_num=" + e_num + ", u_num=" + u_num + "]";
	}
	public E_wrongnote(int e_num, int u_num) {
		super();
		this.e_num = e_num;
		this.u_num = u_num;
	}
	
	
	

}
