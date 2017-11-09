package com.doksusa.e_solution;

public class E_solutionDTO {
	
	int e_num;
	String e_sol;
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public String getE_sol() {
		return e_sol;
	}
	public void setE_sol(String e_sol) {
		this.e_sol = e_sol;
	}
	@Override
	public String toString() {
		return "E_solutionDTO [e_num=" + e_num + ", e_sol=" + e_sol + "]";
	}

	public E_solutionDTO(int e_num, String e_sol) {
		super();
		this.e_num = e_num;
		this.e_sol = e_sol;
	}
	
	
	

}
